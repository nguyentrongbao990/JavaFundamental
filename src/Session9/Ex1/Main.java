package Session9.Ex1;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 4);

        double area = r.getArea();
        double perimeter = r.getPerimeter();

        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);

        System.out.println("----- Rectangle Info -----");
        r.printInfo();
    }
}