
import Relatable;

public abstract class BasicShape implements Relatable {
    protected int[] color;

    public BasicShape() {
        color = new int[3];
        color[0] = 255;
        color[1] = 255;
        color[2] = 255;
    }

    public BasicShape(int r, int g, int b) throws IllegalArgumentException{
        if (
                (((r>255)||(r<0)) ||
                        ((g>255)||(g<0)) )||
                        ((b>255)||(b<0))
        ) throw new IllegalArgumentException();
        color = new int[3];
        color[0] = r;
        color[1] = g;
        color[2] = b;
    }

    /**
     * Getter
     * @return colors {r,g,b}
     */
    public int[] getColor() {
        return color.clone();
    }

    /**
     * Setter - color
     *
     * @param color color must be 3 in length, all value in range [0,255]
     * @throws IllegalArgumentException if requirements are not meet
     */
    public void setColor(int[] color) throws IllegalArgumentException{
        if (color.length!=3)
            throw new IllegalArgumentException();
        for (int c :color) {
            if ((c>255)||(c<0))
                throw new IllegalArgumentException();
        }
        this.color = color.clone();
    }

    public abstract double getArea();

    public boolean equals(Object s){
        if (!(s instanceof BasicShape)) {
            System.out.println("[ERROR] Should be unreachable, " +
                    "line uid: E356EE51-58C8-4505-8E44-7AF8558271D8");
            return false;
        }
        BasicShape shape = (BasicShape) s;
        return (this.getArea()-shape.getArea())<0.0000000000001;
        // Double Comparision, to avoid accuracy issues.
    }
    public boolean isGreater(Object s){
        if (!(s instanceof BasicShape)) {
            System.out.println("[ERROR] Should be unreachable, " +
                    "line uid: E356EE51-58C8-4505-8E44-7AF8558271D8");
            return false;
        }
        BasicShape shape = (BasicShape) s;
        return (this.getArea()>shape.getArea());
    }
    public boolean isLess(Object s){
        if (!(s instanceof BasicShape)) {
            System.out.println("[ERROR] Should be unreachable, " +
                    "line uid: E356EE51-58C8-4505-8E44-7AF8558271D8");
            return false;
        }
        BasicShape shape = (BasicShape) s;
        return (this.getArea()<shape.getArea());
    }


    @Override
    public BasicShape clone() {
        try {
            if (this instanceof Circle)
                return (Circle) super.clone();
            return (BasicShape) super.clone();
        } catch (CloneNotSupportedException ignored) {
            System.out.println("[ERROR] Clone Not Supported.");
            System.out.println(toString());
            System.exit(1);
        }
        System.out.println("[ERROR] Should be unreachable, " +
                "line uid: 2063D294-5A39-4B9A-9674-258A7BE5FC2E");
        return null; // Should be unreachable
    }


}
