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
- Similar to a Linked List except that it branches in multiple directions.
- Binary Search Tree nodes branch left and right.
- Nodes on the left are less than nodes on the right.
- Tree Definitions
    - `Full Tree` -> Each node points to 0 or 2 nodes.
    - `Perfect Tree` -> Each node has both left and right nodes filled with data.
    - `Complete Tree` -> The furthest reaching row in the tree is filled from left to right.
- Big O Information:
    - O(logN) -> Uses Divide and Conquer to achieve this. Most nodes get completely ignored.
