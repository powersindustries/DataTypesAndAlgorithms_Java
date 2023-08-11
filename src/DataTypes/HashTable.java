package DataTypes;

import DataTypes.Types.HashTableEntry;

import java.util.LinkedList;

public class HashTable {
    private static final double DEFAULT_LOADFACTOR = 0.75;
    public LinkedList<HashTableEntry> bucket;
    public LinkedList<HashTableEntry> table[];
    private int tableSize;
    private int threashold;
    private int count = 0;
    private double loadFactor = 0;

    public HashTable(int inSize, double... inLoadFactor) {
        tableSize = inSize;
        table = new LinkedList[tableSize];

        if (loadFactor != 0) {
            loadFactor = inLoadFactor[0];
            threashold = (int) (loadFactor * tableSize);
        } else {
            this.threashold = (int) (DEFAULT_LOADFACTOR * tableSize);
        }
    }

    private int hashingHelper(int inHash) {
        return Math.abs(inHash) % tableSize;
    }

    private void resizeTable() {
        tableSize *= 2;
        threashold = (int) (loadFactor * tableSize);

        LinkedList<HashTableEntry> newHashTable[] = new LinkedList[tableSize];

        for (int x = 0; x < table.length; ++x) {
            if (table[x] != null) {
                for (HashTableEntry entry : table[x]) {
                    int index = hashingHelper(entry.hash);
                    LinkedList<HashTableEntry> bucket = newHashTable[index];
                    if (bucket == null) {
                        bucket = new LinkedList<HashTableEntry>();
                    }

                    bucket.add(entry);
                    newHashTable[index] = bucket;
                }
            }
        }

        table = newHashTable;
    }

    public void addEntry(String inKey, String inValue) {
        HashTableEntry newHashTableEntry = new HashTableEntry(inKey, inValue);

        if (count > threashold) {
            resizeTable();
        }

        int hash = hashingHelper(newHashTableEntry.hash);
        LinkedList<HashTableEntry> bucket = table[hash];

        if (bucket == null) {
            bucket = new LinkedList<HashTableEntry>();
        }

        bucket.add(newHashTableEntry);
        table[hash] = bucket;

        count++;
    }

    public HashTableEntry getEntry(String inKey) {
        int hash = hashingHelper(HashTableEntry.calculateHash(inKey));
        LinkedList<HashTableEntry> bucket = table[hash];

        for (HashTableEntry entry : bucket) {
            if (entry.key == inKey) {
                return entry;
            }
        }
        return null;
    }

    public void remove(String inKey) {
        int hash = hashingHelper(HashTableEntry.calculateHash(inKey));
        LinkedList<HashTableEntry> bucket = table[hash];

        for (HashTableEntry entry : bucket) {
            if (entry.key == inKey) {
                bucket.remove(entry);
            }
        }

        if (bucket.size() == 0) {
            table[hash] = null;
        }
    }

}
