//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 19/04/22
***
*** PlanarShape:
*** Abstract class to define all of the methods used in each shapes implementation and. 
*** the implementation of the Comparable interface. Methods toString, area() and originDistance 
*** are defined as well as the implementation of compareTo from the Comparable interface.
**/
//---------------------------------------------------------------------------------------------------

import java.lang.Math;

public abstract class PlanarShape implements Comparable<PlanarShape>{
    
    private Point[] points;

    // Default Constructor
    public PlanarShape(){

    }

    // Returns a string with the shapes data
    @Override
    public abstract String toString();

    // Returns the area of the shape 
    public abstract double area();

    // Returns the shapes distance from (0,0)
    public abstract double originDistance();

    // Implementation of the compareTo method from the standard Comparable interface used to compare two shapes by their area or distance from (0,0)
    @Override
    public int compareTo(PlanarShape shape){
        double numerator = Math.abs(shape.area() - this.area()); // Absolute number of the target shapes area minus the new shape (Numerator)
        double denominator = (shape.area() + this.area() / 2); // Value of both shapes area divided by two (Denominator)
        double percentDifference = (numerator / denominator) * 100; // Percent different = Numerator divided by denominator multiplied by 100
        if(percentDifference > 0.05 && this.area() < shape.area()){ //  if the percent difference is within 0.05% and the area of the new shape is < the targets area
            return -1; // Returns -1 (False - is not greater)
        }
        else if(percentDifference <= 0.05){ // If the percent difference is <= 0.05
            if(this.originDistance() > shape.originDistance()){ // If the new shapes distance from (0,0) < the target shapes distance from (0,0)
                return -1; // Returns -1 (False - is not greater)
            }
        }
        return 1; // Returns 1 (True - is greater)
    }
    
}