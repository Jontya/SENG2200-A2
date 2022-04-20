//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 20/04/22
***
*** Node:
*** Node class to store shapes of type PlanarShape, implements methods to get and set data / links
**/
//---------------------------------------------------------------------------------------------------

public class Node<T extends PlanarShape>{

    private T data;
    private Node<T> next;
    private Node<T> prev;

    // Default Constructor
    public Node(){
        data = null;
    }

    public Node(T _data){
        data = _data;
    }

    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public T getData(){
        return data;
    }

    public void setNext(Node<T> _next){
        next = _next;
    }

    public void setPrev(Node<T> _prev){
        prev = _prev;
    }
}
