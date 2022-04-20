import java.lang.Math;

public class Polygon extends PlanarShape{
    private Point[] points;
    private int sides;

    public Polygon(double[] values){
        sides = (int)values[0];
        points = new Point[sides];
        int x = 1;
        for(int i = 0; i < sides; i++){
            points[i] = new Point(values[x], values[x+1]);
            x += 2;
        }
    }

    public String toString(){
        String output = "POLY=[";
        for(int i = 0; i < sides; i++){
            output = output + points[i].toString();
        }
        output = output + "]: " + String.format("%5.2f", area());
        return output;
    }

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

    public double originDistance(){
        double distance = 0;
        for(int i = 0; i < sides; i++){
            double temp = points[0].distanceFromOrigin();
            if(temp < distance || i == 0){
                distance = temp;
            }
        }
        return distance;
    }

}
