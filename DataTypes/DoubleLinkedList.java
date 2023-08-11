package DataTypes;

import DataTypes.Types.DoubleLinkedListNode;

public class DoubleLinkedList {
    private DoubleLinkedListNode headNode;
    private int nodeCount;

    public DoubleLinkedList() {
        headNode = null;
        nodeCount = 0;
    }

    public void printNodes() {
        if (headNode == null) {
            System.out.println("Single Linked List is empty.");
            return;
        }

        DoubleLinkedListNode tempDoubleLinkedListNode = headNode;
        while (tempDoubleLinkedListNode != null) {
            System.out.print(tempDoubleLinkedListNode.data + " ");
            tempDoubleLinkedListNode = tempDoubleLinkedListNode.nextNode;
        }

        System.out.println();
    }

    public void addNodeToEnd(int inData) {
        DoubleLinkedListNode newDoubleLinkedListNode = new DoubleLinkedListNode(inData);

        if (nodeCount == 0) {
            headNode = newDoubleLinkedListNode;
            nodeCount++;
            return;
        }

        DoubleLinkedListNode tempDoubleLinkedListNode = headNode;
        while (tempDoubleLinkedListNode != null) {
            if (tempDoubleLinkedListNode.nextNode == null) {
                tempDoubleLinkedListNode.nextNode = newDoubleLinkedListNode;
                newDoubleLinkedListNode.previousNode = tempDoubleLinkedListNode;
                newDoubleLinkedListNode.nextNode = null;

                nodeCount++;
                return;
            }

            tempDoubleLinkedListNode = tempDoubleLinkedListNode.nextNode;
        }
    }

    public void addNodeToBeginning(int inData) {
        DoubleLinkedListNode newDoubleLinkedListNode = new DoubleLinkedListNode(inData);

        if (headNode == null) {
            headNode = newDoubleLinkedListNode;
        } else {
            newDoubleLinkedListNode.nextNode = headNode;
            newDoubleLinkedListNode.previousNode = null;

            headNode.previousNode = newDoubleLinkedListNode;

            headNode = newDoubleLinkedListNode;
        }

        nodeCount++;
    }

    public void insertNodeAtIndex(int index, int inData) {
        if (index > nodeCount) {
            addNodeToEnd(inData);
        } else if (index == 0) {
            addNodeToBeginning(inData);
        } else {
            DoubleLinkedListNode newDoubleLinkedListNode = new DoubleLinkedListNode(inData);
            DoubleLinkedListNode tempDoubleLinkedListNode = headNode;

            int tempIndex = 0;
            while (tempDoubleLinkedListNode != null) {
                if (tempIndex == index) {
                    newDoubleLinkedListNode.nextNode = tempDoubleLinkedListNode;
                    newDoubleLinkedListNode.previousNode = tempDoubleLinkedListNode.previousNode;

                    tempDoubleLinkedListNode.previousNode.nextNode = newDoubleLinkedListNode;
                    tempDoubleLinkedListNode.previousNode = newDoubleLinkedListNode;

                    nodeCount++;
                    return;
                }

                tempDoubleLinkedListNode = tempDoubleLinkedListNode.nextNode;
                tempIndex++;
            }
        }
    }

    public void deleteNodeAtIndex(int index) {
        if (index > nodeCount) {
            System.out.print("Index is out of range of linked list.");
            return;
        }

        if (index == 0) {
            headNode = headNode.nextNode;
            headNode.previousNode = null;

            nodeCount--;
            return;
        }

        DoubleLinkedListNode tempDoubleLinkedListNode = headNode;
        int tempIndex = 0;
        while (tempDoubleLinkedListNode != null) {
            if (tempIndex == index) {
                tempDoubleLinkedListNode.nextNode.previousNode = tempDoubleLinkedListNode.previousNode;
                tempDoubleLinkedListNode.previousNode.nextNode = tempDoubleLinkedListNode.nextNode;

                nodeCount--;
                return;
            }

            tempDoubleLinkedListNode = tempDoubleLinkedListNode.nextNode;
            tempIndex++;
        }
    }

    public void reverseList() {
        DoubleLinkedListNode tempDoubleLinkedListNode = new DoubleLinkedListNode();
        DoubleLinkedListNode currentDoubleLinkedListNode = headNode;

        while (currentDoubleLinkedListNode != null) {
            tempDoubleLinkedListNode = currentDoubleLinkedListNode.previousNode;

            currentDoubleLinkedListNode.previousNode = currentDoubleLinkedListNode.nextNode;
            currentDoubleLinkedListNode.nextNode = tempDoubleLinkedListNode;
            currentDoubleLinkedListNode = currentDoubleLinkedListNode.previousNode;
        }

        if (tempDoubleLinkedListNode != null) {
            headNode = tempDoubleLinkedListNode.previousNode;
        }

    }

}
