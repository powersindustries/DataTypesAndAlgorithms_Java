package DataTypes.Types;

public class DoubleLinkedListNode {
    public DoubleLinkedListNode nextNode;
    public DoubleLinkedListNode previousNode;
    public int data;

    public DoubleLinkedListNode() {
        nextNode = null;
        previousNode = null;
        data = 0;
    }

    public DoubleLinkedListNode(int inData) {
        nextNode = null;
        previousNode = null;
        data = inData;
    }

}
