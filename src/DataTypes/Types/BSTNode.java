package DataTypes.Types;

public class BSTNode {
    public BSTNode leftNode;
    public BSTNode rightNode;
    public int data;

    public BSTNode() {
        leftNode = null;
        rightNode = null;
        data = 0;
    }

    public BSTNode(int inData) {
        leftNode = null;
        rightNode = null;
        data = inData;
    }
}
