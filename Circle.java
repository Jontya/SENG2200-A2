import java.lang.Math;

public class Circle extends PlanarShape{
    private Point centrePoint;
    private double radius;


    public Circle(double[] values){
        centrePoint = new Point(values[0], values[1]);
        radius = values[2];
    }

    @Override
    public String toString(){
        return "CIRC=[" + centrePoint.toString() + " " + String.format("%3.2f", radius) + "]: " + String.format("%5.2f", area());
    }

    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double originDistance(){
        return centrePoint.distanceFromOrigin() - radius;
    }
}
