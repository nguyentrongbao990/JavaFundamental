package Session11.Ex4;

public class Laptop extends Device implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đã được bật.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đã được tắt.");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đang kết nối WiFi.");
    }

    @Override
    public void charge() {
        System.out.println(name + " đang sạc pin.");
    }
}