public class ShapeFactory implements Factory{
    public PlanarShape shapeFactory(char shapeSignature, double[] shapePoints) throws Exception{
        PlanarShape shape;
        switch(shapeSignature){
            case 'P':
                shape = new Polygon(shapePoints);
                break;
            case 'C':
                shape = new Circle(shapePoints);
                break;
            case'S':
                shape = new SemiCircle(shapePoints);
                break;
            default:
                throw new Exception("Error: Shape Not Found");
        }
        return shape;
    }
}
