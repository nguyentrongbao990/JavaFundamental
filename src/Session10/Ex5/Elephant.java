package Session10.Ex5;

public class Elephant extends Mammal {

    public Elephant() {
        super();
    }

    public Elephant(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Pawooooo!");
    }

    public void sprayWater() {
        System.out.println(getName() + " is spraying water!");
    }
}