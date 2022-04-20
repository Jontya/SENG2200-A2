public abstract class PlanarShape implements Comparable<PlanarShape>{

    public PlanarShape(){

    }

    @Override
    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();

    @Override
    public int compareTo(PlanarShape shape){
        double numerator = Math.abs(shape.area() - this.area());
        double denominator = (shape.area() + this.area() / 2);
        double percentDifference = (numerator / denominator) * 100;
        if(percentDifference > 0.1 && this.area() < shape.area()){
            return 1;
        }
        else if(percentDifference <= 0.1){
            if(this.originDistance() < shape.originDistance()){
                return 1;
            }
        }
        return -1;
    }
    
}