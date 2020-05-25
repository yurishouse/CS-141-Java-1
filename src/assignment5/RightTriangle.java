package assignment5;

public class RightTriangle {
    private double legA;
    private double legB;

    /**
     * Constructor
     * @param legA x-axis length
     * @param legB y-axis length
     * @throws IllegalArgumentException when leg length is smaller than or equal to 0
     */
    public RightTriangle(double legA, double legB) throws IllegalArgumentException{
        setLegA(legA);
        setLegB(legB);
    }

    /**
     * Constructor - NO Param
     * Defaults to 1
     */
    public RightTriangle() {
        this.legA = 1.0;
        this.legB = 1.0;
    }

    /**
     * Setter - legA
     *
     * @param legA legA
     * @throws IllegalArgumentException when legA <=0
     */
    public void setLegA(double legA) throws IllegalArgumentException{
        if (legA<=0)
            throw new IllegalArgumentException("length cannot be smaller than or equal to 0");
        this.legA = legA;
    }

    /**
     * Setter - legB
     *
     * @param legB legB
     * @throws IllegalArgumentException when legB <=0
     */
    public void setLegB(double legB) throws IllegalArgumentException{
        if (legB<=0)
            throw new IllegalArgumentException("length cannot be smaller than or equal to 0");
        this.legB = legB;
    }

    /**
     * Getter - legA
     * @return legA as double
     */
    public double getLegA() {
        return legA;
    }

    /**
     * Getter - legB
     * @return legB
     */
    public double getLegB() {
        return legB;
    }

    /**
     * get hypotenuse
     * @return hypotenuse as double
     */
    public double getHypotenuse(){
        return Math.sqrt((this.legA*this.legA)+(this.legB*this.legB));
    }

    /**
     * get Area
     * @return area as double
     */
    public double getArea(){
        return ((this.legA*this.legB)/2.0);
    }

    /**
     * getPerimeter
     * @return perimeter as double
     */
    public double getPerimeter(){
        return (this.legA+this.legB+getHypotenuse());
    }

    /**
     * toString
     * @return string representation
     */
    @Override
    public String toString() {
        return "legA = " + legA +
                ", legB = " + legB;
    }
}
