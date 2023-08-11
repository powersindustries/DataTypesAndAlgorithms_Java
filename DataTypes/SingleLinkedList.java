package DataTypes;

import DataTypes.Types.SingleLinkedListNode;

public class SingleLinkedList {
    private SingleLinkedListNode headNode;
    private int nodeCount;

    public SingleLinkedList() {
        headNode = null;
        nodeCount = 0;
    }

    public void printNodes() {
        if (headNode == null) {
            System.out.println("Single Linked List is empty.");
            return;
        }

        SingleLinkedListNode tempSingleLinkedListNode = headNode;
        while (tempSingleLinkedListNode != null) {
            System.out.print(tempSingleLinkedListNode.data + " ");
            tempSingleLinkedListNode = tempSingleLinkedListNode.nextNode;
        }

        System.out.println();
    }

    public void addNodeToEnd(int inData) {
        SingleLinkedListNode newSingleLinkedListNode = new SingleLinkedListNode(inData);

        if (headNode == null) {
            headNode = newSingleLinkedListNode;
            nodeCount++;
            return;
        }

        SingleLinkedListNode tempSingleLinkedListNode = headNode;
        while (tempSingleLinkedListNode != null) {
            if (tempSingleLinkedListNode.nextNode == null) {
                tempSingleLinkedListNode.nextNode = newSingleLinkedListNode;
                break;
            }

            tempSingleLinkedListNode = tempSingleLinkedListNode.nextNode;
        }

        nodeCount++;
    }

    public void addNodeToBeginning(int inData) {
        SingleLinkedListNode newSingleLinkedListNode = new SingleLinkedListNode(inData);

        if (headNode == null) {
            headNode = newSingleLinkedListNode;
            nodeCount++;
            return;
        }

        newSingleLinkedListNode.nextNode = headNode;
        headNode = newSingleLinkedListNode;

        nodeCount++;
    }

    public void insertNodeAtIndex(int index, int inData) {
        if (index == 0) {
            addNodeToBeginning(inData);
        } else if (index >= nodeCount) {
            addNodeToEnd(inData);
        } else {
            SingleLinkedListNode newSingleLinkedListNode = new SingleLinkedListNode(inData);
            SingleLinkedListNode prevSingleLinkedListNode = headNode;

            for (int x = 0; x < index - 1; ++x) {
                prevSingleLinkedListNode = prevSingleLinkedListNode.nextNode;
            }

            newSingleLinkedListNode.nextNode = prevSingleLinkedListNode.nextNode;
            prevSingleLinkedListNode.nextNode = newSingleLinkedListNode;
            nodeCount++;
        }
    }

    public void deleteNodeAtIndex(int index) {
        if (index > nodeCount) {
            System.out.print("Index is out of range of linked list.");
            return;
        }

        if (index == 0) {
            headNode = headNode.nextNode;
            nodeCount--;
            return;
        }

        int tempIndex = 0;
        SingleLinkedListNode tempSingleLinkedListNode = headNode;
        while (tempIndex != (index - 1)) {
            tempSingleLinkedListNode = tempSingleLinkedListNode.nextNode;
            tempIndex++;
        }

        tempSingleLinkedListNode.nextNode = tempSingleLinkedListNode.nextNode.nextNode;
        nodeCount--;
    }


}
