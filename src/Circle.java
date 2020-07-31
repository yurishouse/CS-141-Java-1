

public class Circle extends BasicShape implements Cloneable {
    private int centerX;
    private int centerY;
    private int radius;

    /**
     * Default Constructor
     */
    public Circle() {
        super();
        centerX = 1;
        centerY = 1;
        radius = 1;
    }

    public Circle(int centerX, int centerY, int radius, int[] color) throws IllegalArgumentException {
        super();
        super.setColor(color); // would check array
        if (radius <= 0)
            throw new IllegalArgumentException();
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    /**
     * Setter - centerX
     *
     * @param centerX centerX
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    /**
     * Setter - centerY
     *
     * @param centerY centerY
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    /**
     * Setter - radius
     *
     * @param radius radius
     */
    public void setRadius(int radius) throws IllegalArgumentException{
        if (radius<=0) throw new IllegalArgumentException();
        this.radius = radius;
    }


    @Override
    public String toString() {
        return "Center: ("+centerX+
                ","+centerY+
                "); Radius: "+radius+
                "; Color: ("+super.color[0]+','+super.color[1]+','+super.color[2]+")";
    }


    @Override
    public Circle clone() {
        return (Circle) super.clone();
    }

    @Override
    public double getArea() {
        final double PI = 3.14159265358979323846264338327950288419;
        return ((PI * radius) * radius);
    }
}
