public class SortedLinkedList<T extends PlanarShape> extends LinkedList<T>{

    private Node<T> sentinel;
    private int count;
    
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

        if(count == 0){
            prepend(newShape);
            count++;
            return;
        }

        Node<T> temp = sentinel.getNext();
        for(int i = 0; i < count; i++){
            System.out.println(count);
            if(newShape.compareTo(temp.getData()) == 1){
                shape.setNext(temp);
                shape.setPrev(temp.getPrev());
                temp.getPrev().setNext(shape);
                temp.setPrev(shape);
                System.out.println("SEN");
                count++;
                return;
            }
            if(i+1 == count){
                append(newShape);
                System.out.println("SEN");
                count++;
                return;
            }
            temp = temp.getNext();
        }
    }
}