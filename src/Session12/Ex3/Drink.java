package Session12.Ex3;

public abstract class Drink implements IPromotion {
    private String id;
    private String name;
    private double price;

    public Drink() {
    }

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price = this.price * (1 - percentage / 100);
        }
    }

    public void displayInfo() {
        System.out.println("Mã món: " + id);
        System.out.println("Tên món: " + name);
        System.out.printf("Giá: %.2f%n", price);
    }
}