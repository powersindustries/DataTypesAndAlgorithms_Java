### Data Types and Algorithms


### Linked Lists
- Data container where each piece of data is connects to the next in a sequential line.
- Singly linked lists have a pointer to the next node in the line.
- Doubly linked lists have a pointer to the next and previous node in the line.
- Unlike arrays, data is not saved contiguously in memory.
- Big O Information
    - O(n) -> Adding to the end of the list, inserting nodes, and removing nodes from the list.
    - O(1) -> Adding nodes to the beginning of the list.


### Stacks
- LIFO -> Last in, first out.
- Real life example -> Tennis Ball canister.
- Big O Information
    - O(1) -> Push and Pop.


### Queue
- FIFO -> First in, first out.
- Real life example -> Being in line at the DMV.
- Big O Information:
    - O(1) -> Enqueue and Dequeue.


### Binary Search Tree
- BSTs are similar to a Linked List except that it branches in multiple directions.
- BST nodes branch left and right.
- Nodes on the left are less than nodes on the right.
- Tree Definitions
    - `Full Tree` -> Each node points to 0 or 2 nodes.
    - `Perfect Tree` -> Each node has both left and right nodes filled with data.
    - `Complete Tree` -> The furthest reaching row in the tree is filled from left to right.
- Big O Information:
    - O(logN) -> Uses Divide and Conquer to achieve this. Most nodes get completely ignored.


### Hash Tables
- Hash Tables are a data container where each piece of data is searchable through a {Key, Value} pair.
- How It works:
    - Array with a prime number amount of entries.
    - When adding a new entry, we take the key and hash it. This Hash value becomes the index in the array.
        - `Hash Method` -> Takes a string and turns it into a number. Calculation is 1 way, you can turn the key to a hash but the hashed index cant turn back into the original key.
    - Each entry in the array is a linked list. When we have multiple entries with say key, the duplicate key values get added to the end of the linked list.
- Big O Information:
    - Hash Method -> O(1)
    - Set Method -> O(1)
    - Get Method -> O(1)
