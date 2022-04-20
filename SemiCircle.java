//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 19/04/22
***
*** SemiCircle:
*** Extends PlanarShape implementing the toString, area and originDistance methods for the semi 
*** circle shape as well as a method to calculate the radius. Stores the point for the centre
*** of the base, perpendicular from the base, left of the base and right of the base.
**/
//---------------------------------------------------------------------------------------------------

import java.lang.Math;

public class SemiCircle extends PlanarShape{

    private Point[] points = new Point[4];

    // Default Constructor
    public SemiCircle(double[] values){ // Creates and stores points
        points[0] = new Point(values[0], values[1]); // Centre of the base
        points[1] = new Point(values[2], values[3]); // Perpendicular of the base

        // Left of the base
        points[2] = new Point(points[0].getx() - Math.abs(points[0].gety() - points[1].gety()), points[0].gety() + Math.abs(points[0].getx() - points[1].gety()));
        // Right of the base
        points[3] = new Point(points[0].getx() + Math.abs(points[0].gety() - points[1].gety()), points[0].gety() - Math.abs(points[0].getx() - points[1].getx()));
    }

    // Returns radius of the semi circle
    public double getRadius(){
        return Math.sqrt(Math.pow((points[1].getx() - points[0].getx()), 2) + Math.pow((points[1].gety() - points[0].gety()), 2));
    }

    // Returns string with the shape name, points and area
    @Override
    public String toString(){
        return "SEMI=[" + points[0].toString() + points[1].toString() + "]: " +  String.format("%5.2f", area());
    }

    // Returns the shapes area
    public double area(){
        return Math.PI * Math.pow(getRadius(), 2) / 2;
    }

    // Compares each point for the least distance
    public double originDistance(){
        double distance = points[0].distanceFromOrigin();
        if(points[1].distanceFromOrigin() < distance){
            distance = points[1].distanceFromOrigin();
        }
        if(points[2].distanceFromOrigin() < distance){
            distance = points[2].distanceFromOrigin();
        }
        if(points[3].distanceFromOrigin() < distance){
            distance = points[3].distanceFromOrigin();
        }
        return distance; // returns the lowest value
    }
    
}
