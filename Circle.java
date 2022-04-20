//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 19/04/22
***
*** Circle:
*** Extends PlanarShape implementing the toString, area and originDistance methods for the circle 
*** shape. Stores the point for the centre of the circle and the circles radius.
**/
//---------------------------------------------------------------------------------------------------

import java.lang.Math;

public class Circle extends PlanarShape{
    private Point centrePoint;
    private double radius;

    // Default Constructor
    public Circle(double[] values){
        centrePoint = new Point(values[0], values[1]);
        radius = values[2];
    }

    // Returns string with the centre point, radius and area
    @Override
    public String toString(){
        return "CIRC=[" + centrePoint.toString() + " " + String.format("%3.2f", radius) + "]: " + String.format("%5.2f", area());
    }

    // Returns the shapes area
    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    // Returns the distance from the closest point to (0, 0)
    public double originDistance(){
        return centrePoint.distanceFromOrigin() - radius;
    }
}
