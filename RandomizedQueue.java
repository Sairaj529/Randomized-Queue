/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        array = (Item[]) new Object[10];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {

        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (array.length == size) { // compare capacity and size
            resize(array, size * 2);
        }

        array[size] = item;

        size++;
    }

    private void resize(Item[] array, int capacity) {

        Item[] newArray = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;

    }

    // remove and return a random item
    public Item dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double ratio = size / (double) array.length;
        if (ratio < 0.25) { // compare capacity and size
            resize(array, size / 2);
        }

        Item returnedValue;
        int randomIndex = StdRandom.uniformInt(0, size);

        if (randomIndex == size - 1) { // btw the corner case wrt last element removal
            returnedValue = array[size - 1];
        }
        else {
            returnedValue = array[randomIndex];
            array[randomIndex] = array[size - 1];
        }


        array[size - 1] = null; // dealing with thrashing
        size--;
        return returnedValue;
    }

    // return a random item (but do not remove it)
    public Item sample() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int randomIndex = StdRandom.uniformInt(0, size);
        Item returnedValue = array[randomIndex];

        return returnedValue;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] arrayCopy;
        private int current;

        public RandomizedQueueIterator() {

            current = 0;
            arrayCopy = (Item[]) new Object[size];

            for (int i = 0; i < size; i++) {
                arrayCopy[i] = array[i];
            }

            StdRandom.shuffle(arrayCopy, 0, size);
        }

        @Override
        public boolean hasNext() {
            return current != size;
        }

        @Override
        public Item next() {
            if (current == size) {
                throw new NoSuchElementException();
            }
            return arrayCopy[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}
