//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 20/04/22
***
*** LinkedList (+ Iterator):
*** Basic Circular Doubly Linked List Functionality implemented using a single sentinel node.
*** Contains methods to add to the lists tail / head, take and remove items from the head and
*** implements the standard methods from the Iterator interface. This list is used to store
*** different Planar Shapes such as Polygons, Semi Circles and Circles.
**/
//---------------------------------------------------------------------------------------------------

import java.util.Iterator;
import java.lang.UnsupportedOperationException;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T>{
    
    protected int count;
    protected int modCount;
    protected Node<T> sentinel;    

    // Default Constructor
    public LinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
        modCount = 0;
    }

    // Throws Exception as they are no longer used
    public void next(){
        throw new UnsupportedOperationException("LinkedList.next(): Invalid Method Of Linked List");
    }

    public void reset(){
        throw new UnsupportedOperationException("LinkedList.next(): Invalid Method Of Linked List");
    }

    // Directs all data into append()
    public void insert(T newShape){
        append(newShape);
    }

    // Adds to the head of the list
    public void prepend(T newShape){
        Node<T> temp = new Node<T>(newShape); // Creates new node
        temp.setNext(sentinel.getNext()); // Sets the new links
        temp.setPrev(sentinel);
        sentinel.getNext().setPrev(temp);
        sentinel.setNext(temp);
        count++;   // Increments count by one
        modCount++; // Increments modification count by one
    }

    // Adds to the tail of the list
    public void append(T newShape){
        Node<T> temp = new Node<T>(newShape); // Creates new node
        temp.setNext(sentinel); // Sets the new links
        temp.setPrev(sentinel.getPrev());
        sentinel.getPrev().setNext(temp);
        sentinel.setPrev(temp);
        count++; // Increments count by one
        modCount++; // Increments modification count by one
    }

    // Takes and removes the head node from the list
    public T remove() throws Exception{
        if(count == 0){
            throw new Exception("List Is Empty"); // Throws exception if the list is empty
        }
        T data = sentinel.getNext().getData(); // Stores node data
        Node<T> temp = sentinel.getNext(); // Resets the links
        temp.getNext().setPrev(sentinel);
        sentinel.setNext(temp.getNext());
        count--; // Decrements count by one
        modCount++; // Increments modification count by one
        return data; // Returns head nodes data
    }

    // Method used to instantiate the iterator implementation
    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    // Implementation of the Iterator public interface
    private class LinkedListIterator implements Iterator<T>{

        private Node<T> current;
        private int expectedMod;

        // Default Constructor
        public LinkedListIterator(){
            current = sentinel;
            expectedMod = modCount;
        }

        // Checks for a next node (returns true if exits / false if it doesn't exist)
        @Override
        public boolean hasNext(){
            return (current.getNext() != sentinel);
        }

        // Moves current to the next node in the list
        @Override
        public T next(){
            if(modCount != expectedMod){ // Checks if the list has been modified since the iterator has be instantiated 
                throw new ConcurrentModificationException("Error: Modified During Iteration");
            }
            if(!hasNext()){ // Throws exception if the list has been already been iterated through
                throw new NoSuchElementException("Error: No More Elements");
            }
            current = current.getNext(); // Moves current to the next node
            return current.getData(); // Returns currents data
        }


    }

}
