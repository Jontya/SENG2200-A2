//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 21/04/22
***
*** ShapeFactory:
*** Implements the Factory interface and provides implementation for the shapeFactory method
**/
//---------------------------------------------------------------------------------------------------

public class ShapeFactory implements Factory{

    // Method takes the shapes signature / token and creates a new instance of shape it requires
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
