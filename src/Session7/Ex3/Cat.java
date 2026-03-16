package Session7.Ex3;

public class Cat extends Animal {
    private String breed;
    public Cat(){}
    public Cat(String name,int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    public void meow(){
        System.out.println("Meow");
    }
    public void display(){
        System.out.println("Cat:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Breed: " + breed);
    }
}
