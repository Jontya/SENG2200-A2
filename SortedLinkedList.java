public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T>{

    public SortedLinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
    }

    public void prepend() throws Exception{
        throw new Exception("Invalid Method Of Sorted Linked List");
    }

    public void append() throws Exception{
        throw new Exception("Invalid Method Of Sorted Linked List");
    }
    
    @Override
    public void insert(T newShape){
        insertInOrder(newShape);
    }

    public void insertInOrder(T newShape){
        Node<T> shape = new Node<T>(newShape);
        Node<T> temp = sentinel.getNext();

        if(count == 0){
            append(newShape);
            return;
        }

        for(int i = 0; i < count; i++){
            if(newShape.compareTo(temp.getData()) == 1){
                shape.setNext(temp);
                shape.setPrev(temp.getPrev());
                temp.getPrev().setNext(shape);
                temp.setPrev(shape);
                count++;
                return;
            }
            else if(i+1 == count){
                append(newShape);
                return;
            }
            temp = temp.getNext();
        }
    }
}