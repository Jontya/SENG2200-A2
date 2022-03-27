public class LinkedList<T extends PlanarShape>{
    
    private int count;
    private Node<T> sentinel;    

    public LinkedList(){
        sentinel = new Node<T>();
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);

        count = 0;
    }

    public void next() throws Exception{
        try{
        }
        catch(Exception e){
            System.out.println("Invalid Method");
        }
    }

    public void reset() throws Exception{
        try{
        }
        catch(Exception e){
            System.out.println("Invalid Method");
        }
    }

    public void prepend(T newShape){
        count++;    
    }

    public void append(T newShape){
        count++;
    }

    public void remove(){

    }

    public void insert(T data){ // Inserts a node before the current node
        append(data);
    }

    public void insertInOrder(T data){
        
    }

    public String print(){
        String out = "";
        return out;
    }
}
