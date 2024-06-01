# Data Types

## Linked Lists
- Data container where each piece of data is connects to the next in a sequential line.
- Singly linked lists have a pointer to the next node in the line.
- Doubly linked lists have a pointer to the next and previous node in the line.
- Unlike arrays, data is not saved contiguously in memory.
- Big O Information
    - O(n) -> Adding to the end of the list, inserting nodes, and removing nodes from the list.
    - O(1) -> Adding nodes to the beginning of the list.


## Stacks
- LIFO -> Last in, first out.
- Real life example -> Tennis Ball canister.
- Big O Information
    - O(1) -> Push and Pop.


## DataTypes.Queue
- FIFO -> First in, first out.
- Real life example -> Being in line at the DMV.
- Big O Information:
    - O(1) -> Enqueue and Dequeue.


## Binary Search Tree
- BSTs are similar to a Linked List except that it branches in multiple directions.
- BST have two branching nodes that go left and right.
- Nodes on the left are less than nodes on the right.
- Tree Definitions
    - `Full Tree` -> Each node points to 0 or 2 nodes.
    - `Perfect Tree` -> Each node has both left and right nodes filled with data.
    - `Complete Tree` -> The furthest reaching row in the tree is filled from left to right.
- Big O Information:
    - O(logN) -> Uses Divide and Conquer to achieve this. Most nodes get completely ignored.


## Hash Tables
- Hash Tables are a data container where each piece of data is searchable through a {Key, Value} pair.
- How It works:
    - Array with a prime number amount of entries.
    - When adding a new entry, we take the key and hash it. This Hash value becomes the index within the array.
        - `Hash Method` -> Takes a string and turns it into a number. Calculation is 1 way, you can turn the key to a hash but the hashed index cant turn back into the original key.
    - Each entry in the array is a linked list. When we have multiple entries with say key, the duplicate key values get added to the end of the linked list.
- Collisions -> When multiple values have the same key.
    - This use case is handled by having each value in the array be a linked list.
- Big O Information:
    - Hash Method -> O(1)
    - Set Method -> O(1)
    - Get Method -> O(1)


## Graphs
- Anatomy of a graph:
    - `Vertex` -> Circle on diagram that contains piece of data.
        - There can be no limit to number of edges that branch off a Vertex.
    - `Edge` -> Line on the diagram that connects two Vertices.
        - Edges can be weighted. This adds a value to an edge between two vertices.
        - Edges can be directional. We assume most edges are 2 directional, but sometimes its only one.
- Common Types of DataTypes.Graph Representations:
    - `Adjacency Matrix` -> DataTypes.Graph where the data is outlined in a 2x2 matrix.
        - The rows represent the vertex and the columns represent what has edges connecting to the vertices.
        - Great for displaying weights of edges. Not very efficient.
    - `Ajacency List` -> Represent the graph using a hash map where the key is the vertex and the value is an array of vertices.
        - The keys in the hashmap represent the vertices.
        - The values at each key are the edges.
        - Much more efficient than an Adjacency Matrix (O(1) in most cases).


## Heap
- A heap is a tree data structure where each node is greater than its descendants or less than its descendants.
    - `Max DataTypes.Heap` -> Each node is greater than its descendants.
    - `Min DataTypes.Heap` -> Each node is less than its descendants.
```
Max DataTypes.Heap:
     10
   /    \
  9      8
 / \    / \
5   6  3   1

Min DataTypes.Heap:
     1
   /   \
  3     6
 / \   / \
5   9 8  10
```
- Implemented using an array. Each operation shifts around the values in the array.
- Typically used as a Priority DataTypes.Queue (DataTypes.Heap and Priority DataTypes.Queue used interchangeably).
- Big O Information:
    - Remove -> O(logN)
    - Insert -> O(logN)



# Algorithms

### Bubble Sort
- Start at the end. Compare two items next to one another. If they one on left is greater than right, swap the two.
- Continue this process until no swaps happen.
- The smallest value "Bubbles Up."
- When to Use:
    - Mostly used for educational purposes.
    - Not very efficient: O(n^2)

### Selection Sort
- Index based sort.
- Start at index 0 and search for the index with the smallest value.
- When the min index has been found, swap it with the comparative index.
- Go down the line and repeat this process until the data has been sorted.
- When to Use:
    - Mostly used for educational purposes.
    - Not very efficient: O(n^2)


### Insertion Sort
- Start with second item in list.
- Compare it to the item on the left. If its less the two swap.
- Continue to move left until reaching the first item in the array.
- When to Use:
    - Mostly used for educational purposes. Best of the "educational" sorts.
    - Good for small and nearly sorted datasets.
    - Not very efficient: O(n^2)


### Merge Sort
- Central Idea: Take multiple sorted lists and then combine into one sorted list.
- How it works
    - Take the list of items, break it out into separate lists until each entry is in its own list.
    - Take two of the single item lists and combine them. Sort the small combined list.
    - Continue this process until one list remains with all sorted items.
- When to Use:
  - Very efficient: O(n log(n))
  - Great for large data sets.


### Quick Sort
- Central Idea: Pivot point sorting with `Divide and Conquer`.
- How it works
    - Pick a pivot point (Index 0).
    - Go down the line from the pivot point and compare each value to the pivot point value.
    - If the value is less than the pivot point, swap the pivot point value with the first value that is greater than.
    - After cycling through once, swap the pivot point with last item in the less than group.
    - Run quick sort again on the less than and greater than blocks of values.
    - Continue this process until we have each value in their own block (blocks array == inputArray.length)
- When to Use:
  - Very efficient: O(n log(n))
  - Great for in-place sorting, because we are swapping values and not allocating memory.
  - Faster for small to medium sized set. Merge Sort is faster for larger sets.