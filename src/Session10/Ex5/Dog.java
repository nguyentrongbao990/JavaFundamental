package Session10.Ex5;

public class Dog extends Mammal {

    public Dog() {
        super();
    }

    public Dog(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }

    public void fetchBall() {
        System.out.println(getName() + " is fetching the ball.");
    }
}