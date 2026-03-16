package Session7.Ex3;

public class Animal {
    protected String name;
    protected int age;
    public Animal() {
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println("Animal is making sound");
    }
}
