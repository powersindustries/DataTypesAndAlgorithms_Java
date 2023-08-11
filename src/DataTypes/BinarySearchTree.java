package DataTypes;

import DataTypes.Types.BSTNode;

import java.util.Stack;

public class BinarySearchTree {
    private BSTNode rootNode;

    public BinarySearchTree() {
        rootNode = null;
    }

    public void print() {
        BSTNode tempBSTNode = rootNode;
        Stack<BSTNode> tempStack = new Stack<BSTNode>();

        while (tempBSTNode != null || !tempStack.empty()) {
            if (tempBSTNode != null) {
                tempStack.push(tempBSTNode);
                tempBSTNode = tempBSTNode.leftNode;
            } else {
                tempBSTNode = tempStack.peek();
                tempStack.pop();

                System.out.print(tempBSTNode.data + " ");
                tempBSTNode = tempBSTNode.rightNode;
            }
        }

        System.out.println();
    }

    boolean find(int inData) {
        if (rootNode == null) {
            System.out.println("Tree is empty.");
            return false;
        }

        BSTNode tempBSTNode = rootNode;
        while (tempBSTNode != null) {
            if (tempBSTNode.data > inData) {
                tempBSTNode = tempBSTNode.leftNode;
            } else if (tempBSTNode.data < inData) {
                tempBSTNode = tempBSTNode.rightNode;
            } else if (tempBSTNode.data == inData) {
                return true;
            }
        }

        return false;
    }

    void insert(int inData) {
        BSTNode newBSTNode = new BSTNode(inData);

        BSTNode tempBSTNode = rootNode;
        BSTNode iteratorBSTNode = null;

        while (tempBSTNode != null) {
            iteratorBSTNode = tempBSTNode;
            if (inData < tempBSTNode.data) {
                tempBSTNode = tempBSTNode.leftNode;
            } else {
                tempBSTNode = tempBSTNode.rightNode;
            }
        }

        if (iteratorBSTNode == null) {
            rootNode = newBSTNode;
        } else if (inData < iteratorBSTNode.data) {
            iteratorBSTNode.leftNode = newBSTNode;
        } else {
            iteratorBSTNode.rightNode = newBSTNode;
        }
    }

    void delete(int inData) {
        if (rootNode == null) {
            System.out.println("Tree is empty.");
            return;
        }

        BSTNode parentBSTNode = rootNode;
        BSTNode tempBSTNode = rootNode;

        while (tempBSTNode != null) {
            if (inData < tempBSTNode.data) {
                parentBSTNode = tempBSTNode;
                tempBSTNode = tempBSTNode.leftNode;
            } else if (inData > tempBSTNode.data) {

                parentBSTNode = tempBSTNode;
                tempBSTNode = tempBSTNode.rightNode;
            } else {
                if (tempBSTNode.leftNode == null && tempBSTNode.rightNode == null) {
                    if (parentBSTNode.leftNode == tempBSTNode) {
                        parentBSTNode.leftNode = null;
                    } else {
                        parentBSTNode.rightNode = null;
                    }

                    return;
                } else if (tempBSTNode.leftNode == null || tempBSTNode.rightNode == null) {

                    if (tempBSTNode.leftNode != null) {
                        parentBSTNode.leftNode = tempBSTNode.leftNode;
                    } else {
                        parentBSTNode.rightNode = tempBSTNode.rightNode;
                    }

                    return;
                } else {

                    BSTNode iteratorBSTNode = tempBSTNode.rightNode;
                    if (iteratorBSTNode.leftNode == null && iteratorBSTNode.rightNode == null) {
                        tempBSTNode.data = iteratorBSTNode.data;
                        tempBSTNode.rightNode = null;

                        return;
                    } else if (iteratorBSTNode.leftNode == null && iteratorBSTNode.rightNode != null) {
                        tempBSTNode.data = iteratorBSTNode.data;
                        tempBSTNode.rightNode = iteratorBSTNode.rightNode;

                        return;
                    }

                    while (iteratorBSTNode.leftNode != null) {
                        parentBSTNode = iteratorBSTNode;
                        iteratorBSTNode = iteratorBSTNode.leftNode;
                    }

                    tempBSTNode.data = iteratorBSTNode.data;
                    parentBSTNode.leftNode = null;

                    return;
                }
            }
        }

        return;
    }
}
