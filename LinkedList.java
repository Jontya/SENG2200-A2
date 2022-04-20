import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinkedList<T extends PlanarShape> implements Iterable<T>{
    
    protected int count;
    protected int modCount;
    protected Node<T> sentinel;    

    public LinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
        modCount = 0;
    }

    public void next() throws Exception{
        throw new Exception("Invalid Method Of Linked List");
    }

    public void reset() throws Exception{
        throw new Exception("Invalid Method Of Linked List");
    }

    public void insert(T newShape){
        append(newShape);
    }

    public void prepend(T newShape){
        Node<T> temp = new Node<T>(newShape);
        temp.setNext(sentinel.getNext());
        temp.setPrev(sentinel);
        sentinel.getNext().setPrev(temp);
        sentinel.setNext(temp);
        count++;   
        modCount++; 
    }

    public void append(T newShape){
        Node<T> temp = new Node<T>(newShape);
        temp.setNext(sentinel);
        temp.setPrev(sentinel.getPrev());
        sentinel.getPrev().setNext(temp);
        sentinel.setPrev(temp);
        count++;
        modCount++;
    }

    public T remove(){
        if(count == 0){
            return null;
        }
        T data = sentinel.getNext().getData();
        Node<T> temp = sentinel.getNext();

        temp.getNext().setPrev(sentinel);
        sentinel.setNext(temp.getNext());
        count--;
        modCount++;
        return data;
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    
    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current;
        private int expectedMod;

        public LinkedListIterator(){
            current = sentinel;
            expectedMod = modCount;
        }

        @Override
        public boolean hasNext(){
            return (current.getNext() != sentinel);
        }

        @Override
        public T next(){
            if(modCount != expectedMod){
                throw new ConcurrentModificationException("Error: Modified During Iteration");
            }
            if(!hasNext()){
                throw new NoSuchElementException("Error: No More Elements");
            }
            current = current.getNext();
            return current.getData();
        }


    }

}
