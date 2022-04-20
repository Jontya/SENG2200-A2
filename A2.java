//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 21/04/22
***
*** A2:
*** Reads in a file with multiple shapes with their points on the Cartesian Plain and stores them
*** in a circular doubly linked list. Provides methods to read the file and produce the outputs
*** for each list.
**/
//---------------------------------------------------------------------------------------------------

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

    private void readFile() throws Exception{
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

        
        while(scanner.hasNext()){ // Reads through the file
            temp = scanner.next(); // Stores the next character
            if(temp.charAt(0) == 'P' || temp.charAt(0) == 'S' || temp.charAt(0) == 'C' || !scanner.hasNext()){ // If that character is a shape identifier
                if(!scanner.hasNext()){ // If the last shape has been read
                    fileData += temp;
                    count++;
                }
                
                double[] shapeData = new double[count]; // Array of doubles for the shape data
                String[] arr = fileData.split("\\s"); // Splits the string into an array of single characters
                for(int i = 0; i < count; i++){ // for each character
                    shapeData[i] = Double.parseDouble(arr[i]); // the double array is updated
                }

                ShapeFactory sf = new ShapeFactory(); // Instance of ShapeFactory
                unsortedList.append(sf.shapeFactory(shapeToken, shapeData)); // Adds to the list with the shape determined in the shape factory
              
                shapeToken = temp.charAt(0); // Updates the shape token
                fileData = ""; // Resets the data string
                count = 0; // Resets count
            }
            else{
                fileData += temp + " "; // Adds to the data string
                count++; // Increments count by one
            }
        }

        addToSortedList(); // Adds to sorted list and prints both lists
        System.out.print(outputUnsortedList());
        System.out.print(outputSortedList());
    }

    private void addToSortedList(){
        Iterator<PlanarShape> iterator = unsortedList.iterator(); // New iterator
        while(iterator.hasNext()){ // for each node in the linked list
            sortedList.insertInOrder(iterator.next()); // Insert in descending order
        }
    }

    private String outputUnsortedList(){
        Iterator<PlanarShape> iterator = unsortedList.iterator(); // New iterator
        String out = "Unsorted list\n";
        while(iterator.hasNext()){
            out += (iterator.next().toString()) + "\n"; // Adds shape specs 
        }
        return out;
    }

    private String outputSortedList(){
        Iterator<PlanarShape> iterator = sortedList.iterator(); // New iterator
        String out = "Sorted list\n";
        while(iterator.hasNext()){
            out += (iterator.next().toString()) + "\n"; // Adds shape specs 
        }
        return out;
    }
}
