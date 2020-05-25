package assignment5;

public class Point {
    private double x_cord;
    private double y_cord;

    /**
     * Constructor - NO param
     */
    public Point() {
        this.x_cord = 1.0;
        this.y_cord = 1.0;
    }

    /**
     * Default Constructor
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x_cord, double y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    /**
     * Getter - x cord
     * @return x coordinate as double
     */
    public double getX() {
        return x_cord;
    }

    /**
     * Setter - x cord
     * @param x_cord x coordinate
     */
    public void setX(double x_cord) {
        this.x_cord = x_cord;
    }

    /**
     * Getter - y cord
     * @return y coordinate as double
     */
    public double getY() {
        return y_cord;
    }

    /**
     * Setter - y cord
     * @param y_cord y coordinate
     */
    public void setY(double y_cord) {
        this.y_cord = y_cord;
    }

    /**
     * Move a point
     * @param dx dealt x
     * @param dy dealt y
     */
    public void move(double dx,double dy){
        this.x_cord+=dx;
        this.y_cord+=dy;
    }

    /**
     * rotate this point by 90deg with respect to the origin
     */
    public void rotate(){
        double x_tmp = this.x_cord;
        //noinspection SuspiciousNameCombination
        this.x_cord = this.y_cord;
        this.y_cord = -1.0 * x_tmp;
    }
}
