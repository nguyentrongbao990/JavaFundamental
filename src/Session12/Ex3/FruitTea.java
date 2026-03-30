package Session12.Ex3;

public class FruitTea extends Drink {

    public FruitTea() {
    }

    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Cách pha chế: Lắc với đá và trái cây tươi");
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại đồ uống: Fruit Tea");
        super.displayInfo();
        prepare();
    }
}