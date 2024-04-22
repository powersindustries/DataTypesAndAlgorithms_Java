public class Stack {

    private class Node {
        public int data;
        public Node nextNode;

        Node(int inData) {
            data = inData;
            nextNode = null;
        }
    }

    private Node topNode;
    private int size = 0;

    public Stack (int inData) {
        Node newNode = new Node(inData);
        topNode = newNode;

        size++;
    }

    public void print(){
        String output = "";

        Node tempNode = topNode;
        while (tempNode != null) {
            output += tempNode.data + " ";
            tempNode = tempNode.nextNode;
        }

        System.out.println(output);
    }

    // Adds a new item to the end of the stack.
    public void push(int inData){
        Node newNode = new Node(inData);

        if (size == 0) {
            topNode = newNode;
        } else {
            newNode.nextNode = topNode;
            topNode = newNode;
        }

        size++;
    }

    // Removes the last item of the stack, then returns the value that was deleted.
    public Node pop(){
        if (size == 0){
            return null;
        } 

        Node tempNode = topNode;
        topNode = topNode.nextNode;
        tempNode.nextNode = null;

        size--;
        return tempNode;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Stack.");

        Stack stack = new Stack(1);
        stack.push(2);
        stack.push(3);

        stack.print();

        System.out.println("Pop: " + stack.pop().data);
        stack.print();
    }
}

