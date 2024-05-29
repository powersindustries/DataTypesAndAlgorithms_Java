package DataTypes;

import java.util.ArrayList;

public class HashTable {

    private class Node {
        private String key;
        private int value;
        private Node nextNode;

        public Node(String inKey, int inValue) {
            this.key = inKey;
            this.value = inValue;
        }

    }

    // We set size to 7 because prime numbers will result in less collisions.
    private int size = 7;
    private Node[] map;

    public HashTable() {
        map = new Node[size];
    }

    public void print() {
        String output = "";

        for (int x = 0; x < map.length; ++x) {
            Node tempNode = map[x];
            while (tempNode != null) {
                output += "{" + tempNode.key + ", " + tempNode.value + "}";
                tempNode = tempNode.nextNode;
            }
        }

        System.out.println(output);
    }

    // Returns an int that is a hash of the input key string.
    private int hashMethod(String inKey) {
        int output = 0;

        char[] keyChar = inKey.toCharArray();
        for (int x = 0; x < keyChar.length; ++x) {
            int asciiValue = keyChar[x];

            // Using Feel free to use any prime number here.
            output = (output + asciiValue * 19) % map.length;
        }

        return output;
    }

    // Adds a new data entry to the DataTypes.HashTable.
    public void set(String inKey, int inValue) {
        int index = hashMethod(inKey);

        Node newNode = new Node(inKey, inValue);
        // Case for when index is empty. Set empty index to newNode.
        if (map[index] == null) {
            map[index] = newNode;
        }
        // Case for when index already has a node. Add the newNode to the nextNode of the node at index.
        // Similar to push() method in linked list.
        else {
            Node tempNode = map[index];
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }

            tempNode.nextNode = newNode;
        }
    }

    // Returns the data by key as an Int.
    public int get(String inKey) {
        int index = hashMethod(inKey);
        Node tempNode = map[index];
        while (tempNode != null) {
            if (tempNode.key == inKey) {
                return tempNode.value;
            }

            tempNode = tempNode.nextNode;
        }

        return 0;
    }

    // Returns an ArrayList of all the keys in a hash map.
    public ArrayList keys() {
        ArrayList<String> outputKeys = new ArrayList<String>();

        for (int x = 0; x < map.length; ++x) {
            Node tempNode = map[x];
            while (tempNode != null) {
                outputKeys.add(tempNode.key);
                tempNode = tempNode.nextNode;
            }
        }

        return outputKeys;
    }


    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Hash Table.");

        HashTable hashTable = new HashTable();

        hashTable.set("test1", 1);
        hashTable.set("test2", 5);
        hashTable.set("test3", 10);

        hashTable.print();

        System.out.println(hashTable.keys());

    }
}

