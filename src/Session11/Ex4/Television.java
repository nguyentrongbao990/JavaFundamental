package Session11.Ex4;

public class Television extends Device implements Connectable {

    public Television(int id, String name) {
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
}