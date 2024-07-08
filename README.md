# Randomized-Queue
This project presents an efficient implementation of a randomized queue in Java. A randomized queue is similar to a regular queue, but the item removed is chosen uniformly at random from the items currently in the queue. This makes it ideal for applications requiring random sampling.

Features
---
Randomized Enqueue and Dequeue: Supports inserting items at the end and removing items uniformly at random.
Random Sampling: Provides a method to return a random item without removing it from the queue.
Dynamic Resizing: Automatically resizes to accommodate more items, optimizing for memory usage and performance.
Iterable Interface: Allows iteration over the items in random order.

Implementation Details
---
Key Methods
enqueue(Item item): Adds an item to the queue. Resizes the internal array if necessary.
dequeue(): Removes and returns a random item from the queue. Shrinks the internal array if necessary.
sample(): Returns a random item from the queue without removing it.
iterator(): Returns an independent iterator over items in random order.
