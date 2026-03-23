package Session10.Ex5;

public class Cat extends Mammal {

    public Cat() {
        super();
    }

    public Cat(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }

    public void climbTree() {
        System.out.println(getName() + " is climbing a tree.");
    }
}