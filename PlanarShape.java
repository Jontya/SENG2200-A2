public abstract class PlanarShape implements Comparable<PlanarShape>{
    Point points[];

    public PlanarShape(){

    }

    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();

    public int compareTo(PlanarShape shape){
        return 0;
    }
    
}