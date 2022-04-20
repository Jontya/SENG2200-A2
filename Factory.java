public interface Factory {
    PlanarShape shapeFactory(char shapeToken, double[] shapePoints) throws Exception;
}
