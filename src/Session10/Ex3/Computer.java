package Session10.Ex3;

public class Computer {
    public double calculatePrice(double basePrice){
        return basePrice;
    }
    public double calculatePrice(double basePrice, double tax){
        return basePrice+basePrice*tax;
    }
    public double calculatePrice(double basePrice, double tax, double discount){
        return basePrice+basePrice*tax-basePrice*discount;
    }
}
