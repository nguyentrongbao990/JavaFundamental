package Session11.Ex4;

public abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Tên thiết bị: " + name);
    }
}