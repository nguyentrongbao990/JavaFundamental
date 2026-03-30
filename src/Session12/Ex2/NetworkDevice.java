package Session12.Ex2;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice() {
    }

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        if (numberOfPorts > 0) {
            this.numberOfPorts = numberOfPorts;
        }
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9;
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại tài sản: Network Device");
        super.displayInfo();
        System.out.println("Số cổng: " + numberOfPorts);
        System.out.println("Giá trị hiện tại: " + getMarketValue());
    }
}