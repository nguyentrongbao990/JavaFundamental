package Session8.Ex4;

public class Rectangle {
    private double width;
    private double height;
    public Rectangle(){}
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return 2*width+2*height;
    }
    @Override
    public String toString(){
        return String.format("width=%.1f, height=%.1f, area=%.1f, perimeter=%.1f", width, height,getArea(),getPerimeter());
    }
}
