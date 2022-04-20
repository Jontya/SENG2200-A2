//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 21/04/22
***
*** SortedLinkedList:
*** Extends from LinkedList in order to add functionality for the sorted doubly linked list. The 
*** prepend and append methods have been overloaded to instead throw an exception and the insert
*** method has been overridden to direct all data into insertInOrder(). The insertInOrder method
*** allows the list to insert shapes into the list in descending order.
**/
//---------------------------------------------------------------------------------------------------

public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T>{

    // Default Constructor
    public SortedLinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
    }

    // Overloaded to throw an exception
    public void prepend() throws Exception{
        throw new Exception("Invalid Method Of Sorted Linked List");
    }

    public void append() throws Exception{
        throw new Exception("Invalid Method Of Sorted Linked List");
    }
    
    // Overridden to direct all data into insertInOrder()
    @Override
    public void insert(T newShape){
        insertInOrder(newShape);
    }

    // Inserts shapes into the linked list in descending order
    public void insertInOrder(T newShape){
        Node<T> shape = new Node<T>(newShape);
        Node<T> temp = sentinel.getNext();

        if(count == 0){ // If the list is empty the method just adds to the list
            append(newShape);
            return;
        }

        for(int i = 0; i < count; i++){ // Checks through the existing items
            if(newShape.compareTo(temp.getData()) == 1){ // If the item needs to be inserted after the target node
                shape.setNext(temp); // Sets the linkes for the new node
                shape.setPrev(temp.getPrev());
                temp.getPrev().setNext(shape);
                temp.setPrev(shape);
                count++; // Count increments by one
                return;
            }
            else if(i+1 == count){ // If the entire list has been checked
                append(newShape); // Shape is added to end of the list
                return;
            }
            temp = temp.getNext(); // Target moves to next node
        }
    }
}