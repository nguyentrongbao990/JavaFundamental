package Session10.Ex5;

public class Animal {
    private String name;
    private int age;

    public Animal() {
        this.name = "";
        this.age = 0;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    // Overloading
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food + ".");
    }
}