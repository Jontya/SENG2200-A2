import java.util.*;
import java.io.*;


public class A2 {
    private static String filename;
    private LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>(); // Unsorted List
    private SortedLinkedList<PlanarShape> sortedList = new SortedLinkedList<PlanarShape>(); // Sorted List
    public static void main(String[] args) throws Exception{

         // Checks to see if file name exists
         try{
            filename = args[0];
            A2 shapes = new A2();
            shapes.readFile();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Missing Filename Argument");
        }
        
    }

    public void readFile() throws Exception{
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("File Not Found");
            return;
        }
        
        Scanner scanner = new Scanner(file);
        char shapeToken = scanner.next().charAt(0);
        String temp = "";
        String fileData = "";
        int count = 0;

        
        while(scanner.hasNext()){
            temp = scanner.next();
            if(temp.charAt(0) == 'P' || temp.charAt(0) == 'S' || temp.charAt(0) == 'C' || !scanner.hasNext()){
                if(!scanner.hasNext()){
                    fileData += temp;
                    count++;
                }
                
                double[] shapeData = new double[count];
                String[] arr = fileData.split("\\s");
                for(int i = 0; i < count; i++){
                    shapeData[i] = Double.parseDouble(arr[i]);
                }

                ShapeFactory sf = new ShapeFactory();
                unsortedList.append(sf.shapeFactory(shapeToken, shapeData));
              
                shapeToken = temp.charAt(0);
                fileData = "";
                count = 0;
            }
            else{
                fileData += temp + " ";
                count++;
            }
        }

        Iterator<PlanarShape> iterator = unsortedList.iterator();
        while(iterator.hasNext()){
            sortedList.insertInOrder(iterator.next());
        }

        System.out.println("Unsorted list\n" + unsortedList.print());
        System.out.println("Sorted list\n" + sortedList.print());
    }
}
