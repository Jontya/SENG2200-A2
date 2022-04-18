import java.lang.Math;

public class SemiCircle extends PlanarShape{
    private Point centreBase;
    private Point perpendicularBase;
    private Point leftOfBase;
    private Point rightOfBase;

    public SemiCircle(String data){

    }

    public void setSidePoints(){
        leftOfBase.setx(centreBase.getx() - Math.abs(centreBase.gety() - perpendicularBase.gety()));
        leftOfBase.sety(centreBase.gety() + Math.abs(centreBase.getx() - perpendicularBase.gety()));

        rightOfBase.setx(centreBase.getx() + Math.abs(centreBase.gety() - perpendicularBase.gety()));
        rightOfBase.sety(centreBase.gety() - Math.abs(centreBase.getx() - perpendicularBase.getx()));
    }

    public double getRadius(){
        return Math.sqrt(Math.pow((perpendicularBase.getx() - centreBase.getx()), 2) + Math.pow((perpendicularBase.gety() - centreBase.gety()), 2))
    }

    public String toString(){
        return "SEMI=[" + centreBase.toString() + perpendicularBase.toString() + "]: " +  String.format("%5.2f", area());
    }

    public double area(){
        return Math.PI * Math.pow(getRadius(), 2) / 2;
    }

    public double originDistance(){
        double distance = centreBase.distanceFromOrigin();
        if(perpendicularBase.distanceFromOrigin() < distance){
            distance = perpendicularBase.distanceFromOrigin();
        }
        if(leftOfBase.distanceFromOrigin() < distance){
            distance = leftOfBase.distanceFromOrigin();
        }
        if(rightOfBase.distanceFromOrigin() < distance){
            distance = rightOfBase.distanceFromOrigin();
        }
        return distance;
    }
    
}
