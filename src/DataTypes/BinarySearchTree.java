package DataTypes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int inData) {
            data = inData;
            left = null;
            right = null;
        }

    }

    private Node rootNode;

    // Adds a new node to the tree. Returns true if successful and false if unsuccessful.
    public boolean insert(int inData) {
        Node newNode = new Node(inData);

        // Case if the tree is empty.
        if (rootNode == null) {
            rootNode = newNode;
            return true;
        }

        Node tempNode = rootNode;
        while (tempNode != null) {
            if (tempNode.data == newNode.data) {
                return false;
            }

            // Left case.
            if (newNode.data < tempNode.data) {
                if (tempNode.left == null) {
                    tempNode.left = newNode;
                    return true;
                }

                tempNode = tempNode.left;
            }
            // Right case.
            else {
                if (tempNode.right == null) {
                    tempNode.right = newNode;
                    return true;
                }

                tempNode = tempNode.right;
            }
        }

        return false;
    }

    // Checks to see if a number is included in the tree. Returns true if exists and false if it does not exist in the tree.
    public boolean contains(int inData) {

        Node tempNode = rootNode;
        while (tempNode != null) {
            // Check left condition.
            if (inData < tempNode.data) {
                tempNode = tempNode.left;
            }
            // Check right condition.
            else if (inData > tempNode.data) {
                tempNode = tempNode.right;
            }
            // Value was found. Return true.
            else {
                return true;
            }
        }

        return false;
    }

    // Searches for a value in the tree using Breadth First Search (Search left to right, and then down row to row).
    public ArrayList<Integer> BFS() {
        Node currNode = rootNode;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currNode);

        while (queue.size() > 0) {
            currNode = queue.remove();

            results.add(currNode.data);
            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }

        return results;
    }

    // Searches for a value in the tree using PostOrder Depth First Search.
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }

                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }

                results.add(currNode.data);
            }
        }

        new Traverse(rootNode);

        return results;
    }

    // Searches for a value in the tree using InOrder Depth First Search.
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currNode) {
                if (currNode.left != null) {
                    new Traverse(currNode.left);
                }

                results.add(currNode.data);

                if (currNode.right != null) {
                    new Traverse(currNode.right);
                }

            }
        }

        new Traverse(rootNode);

        return results;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Binary Search Tree.");

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(1);
        bst.insert(3);
        bst.insert(4);
        bst.insert(8);

        System.out.println(bst.contains(8));
    }
}
