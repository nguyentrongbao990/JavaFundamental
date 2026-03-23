package Session10.Ex3;

public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer();
        double finalPrice = c1.calculatePrice(1000);
        System.out.println("[Using basePrice only]");
        System.out.printf("Final Price = %.1f%n", finalPrice);
        finalPrice = c1.calculatePrice(1000,0.1);
        System.out.println("[Using basePrice + tax]");
        System.out.printf("Final Price = %.1f%n", finalPrice);
        finalPrice = c1.calculatePrice(1000,0.1,0.05);
        System.out.println("[Using basePrice + tax + discount]");
        System.out.printf("Final Price = %.1f%n", finalPrice);
    }
}
