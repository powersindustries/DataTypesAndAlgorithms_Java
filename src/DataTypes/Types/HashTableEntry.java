package DataTypes.Types;

public class HashTableEntry {
    private static final int CHAR_ASCII = 96;
    private static final int HASH_OFFSET = 27;

    public String key;
    public String value;
    public int hash;

    public HashTableEntry(String inKey, String inValue) {
        key = inKey;
        value = inValue;
        hash = calculateHash(key);
    }

    public static int calculateHash(String key) {
        int output = 0;

        for (int x = 0; x < key.length(); ++x) {
            int asciiCode = key.charAt(x) - CHAR_ASCII;
            output = (output * HASH_OFFSET) + asciiCode;
        }

        return output;
    }

    public void printEntry() {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}