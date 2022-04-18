public abstract class PlanarShape implements Comparable<PlanarShape>{

    public PlanarShape(){

    }

    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();

    public abstract void initShape(double[] values);

    public int compareTo(PlanarShape shape){
        
        double numerator = Math.abs(this.area() - shape.area());
        double denominator = (this.area() + shape.area() / 2);
        double percentDifference = (numerator / denominator) * 100;
        if(percentDifference > 0.1 && this.area() < shape.area()){
            return 1;
        }
        else if(percentDifference <= 0.1){
            return 1;
        }
        return -1;
    }
    
}