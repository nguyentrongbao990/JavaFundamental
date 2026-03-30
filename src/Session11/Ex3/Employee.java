package Session11.Ex3;

public abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    public void showInfo() {
        System.out.println("Mã nhân viên: " + id);
        System.out.println("Tên nhân viên: " + name);
    }
}