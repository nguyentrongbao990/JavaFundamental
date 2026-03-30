package Session12.Ex3;

public class Coffee extends Drink {

    public Coffee() {
    }

    public Coffee(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Cách pha chế: Pha bằng máy");
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại đồ uống: Coffee");
        super.displayInfo();
        prepare();
    }
}