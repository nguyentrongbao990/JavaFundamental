package Session7.Ex3;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom",3,"British Shorthair");
        Dog dog = new Dog("Jack",5,"Brown");
        cat.display();
        cat.makeSound();
        cat.meow();

        System.out.println();

        dog.displayInfo();
        dog.makeSound();
        dog.bark();
    }
}
