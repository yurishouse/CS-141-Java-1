
public class Rectangle extends BasicShape implements Cloneable{
    private int cornerX;
    private int cornerY;
    private int width;
    private int length;

    public Rectangle() {
        super();
        cornerX = 1;
        cornerY = 1;
        width = 1;
        length = 1;
    }

    public Rectangle(int cornerX, int cornerY, int length, int width, int[] color) throws IllegalArgumentException{
        super();
        super.setColor(color);
        if ((width<0)||(length<0))
            throw new IllegalArgumentException();
        this.cornerX = cornerX;
        this.cornerY = cornerY;
        this.width = width;
        this.length = length;
    }

    public int getCornerX() {
        return cornerX;
    }

    /**
     * Setter - cornerX
     *
     * @param cornerX cornerX
     */
    public void setCornerX(int cornerX) {
        this.cornerX = cornerX;
    }

    public int getCornerY() {
        return cornerY;
    }

    /**
     * Setter - cornerY
     *
     * @param cornerY cornerY
     */
    public void setCornerY(int cornerY) {
        this.cornerY = cornerY;
    }

    public int getWidth() {
        return width;
    }

    /**
     * Setter - width
     *
     * @param width width
     */
    public void setWidth(int width) throws IllegalArgumentException{
        if (width<=0)
            throw new IllegalArgumentException();
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    /**
     * Setter - length
     *
     * @param length length
     */
    public void setLength(int length) throws IllegalArgumentException{
        if (length<=0)
            throw new IllegalArgumentException();
        this.length = length;
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public String toString() {
        return "Left Upper Corner: ("+cornerX+","+cornerY+"); Width: "+width+"; Length: "+length+"; Color: ("+super.color[0]+','+super.color[1]+','+super.color[2]+")";
    }

    @Override
    public Rectangle clone() {
        return (Rectangle) super.clone();
    }
}
