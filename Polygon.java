//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 19/04/22
***
*** Polygon:
*** Extends PlanarShape implementing the toString, area and originDistance methods for the polygon
*** shape. Stores an array of points and the number of sides of a Polygon
**/
//---------------------------------------------------------------------------------------------------

import java.lang.Math;

public class Polygon extends PlanarShape{

    private Point[] points;
    private int sides;

    // Default Constructor 
    public Polygon(double[] values){ // Creates and stores points 
        sides = (int) values[0]; // Stores the number of sides
        points = new Point[sides]; // Defines array size
        int x = 1;
        for(int i = 0; i < sides; i++){
            points[i] = new Point(values[x], values[x+1]); // Creates a new point for each array position
            x += 2;
        }
    }

    // Returns string with the shape name, points and area
    public String toString(){
        String output = "POLY=[";
        for(int i = 0; i < sides; i++){
            output = output + points[i].toString(); // Updates output with each point
        }
        output = output + "]: " + String.format("%5.2f", area()); // formats the area
        return output;
    }

    // Returns the shapes area
    public double area(){
        double area_value = 0;
        int j = sides - 1;
        for(int i = 0; i < sides; i++){
            area_value += (points[j].getx() + points[i].getx()) * (points[j].gety() - points[i].gety()); // Equation to get the area
            j = i;
        }
        area_value = area_value / 2; // Area divided by two
        if(area_value <  0){ // Absolute Number if its a negative
            area_value = area_value * (-1);
        }
        return area_value; // returns area
    }

    // Returns the distance from the closest point to (0, 0)
    public double originDistance(){
        double distance = 0;
        for(int i = 0; i < sides; i++){ // Loops through each point
            double temp = points[0].distanceFromOrigin();
            if(temp < distance || i == 0){ // Updates the distance if it is less than the previous
                distance = temp;
            }
        }
        return distance; // Returns the distance from the closest point
    }

}
