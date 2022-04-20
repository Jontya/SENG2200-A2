//---------------------------------------------------------------------------------------------------
/** SENG2200 A2
*** Jonty Atkinson (C3391110)
*** 21/04/22
***
*** Factory:
*** Defines the Factory interface and the shapeFactory method
**/
//---------------------------------------------------------------------------------------------------

public interface Factory {
    
    PlanarShape shapeFactory(char shapeToken, double[] shapePoints) throws Exception;
}
