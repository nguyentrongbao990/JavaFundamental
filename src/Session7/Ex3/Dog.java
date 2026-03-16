package Session7.Ex3;

public class Dog extends Animal {
    private String color;
    public Dog(){}
    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
    public void bark() {
        System.out.println("Barking...");
    }
    public void displayInfo() {
        System.out.println("Dog:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
    }
}
