package Session11.Ex1;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle("Hình chữ nhật", 5, 3);
        shapes[1] = new Circle("Hình tròn", 4);
        shapes[2] = new Rectangle("Hình chữ nhật lớn", 7, 2);

        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.printf("Diện tích: %.2f%n", shape.getArea());
            System.out.printf("Chu vi: %.2f%n", shape.getPerimeter());

            if (shape instanceof Drawable) {
                ((Drawable) shape).draw();
            }

            System.out.println("-------------------------");
        }
    }
}