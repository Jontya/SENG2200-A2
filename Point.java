//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 19/04/22
***
*** Point:
*** Class to store a pair of points (x, y). Provides methods to return a clean string of the point 
*** and calculate the points distance from the origin (0, 0)
**/
//---------------------------------------------------------------------------------------------------

import java.lang.Math;

public class Point {

    private double x;
    private double y;

    // Default Constructor
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    public double distanceFromOrigin(){ // Calculates a points distance from (0, 0)
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public String toString(){ // Clean string for a point "(x, y)"
        return "(" + String.format("%4.2f", x) + " , " + String.format("%4.2f", y) + ")";
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public void setx(double _x){
        x = _x;
    }

    public void sety(double _y){
        y = _y;
    }
    
}