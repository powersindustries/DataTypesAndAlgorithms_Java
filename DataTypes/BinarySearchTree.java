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
