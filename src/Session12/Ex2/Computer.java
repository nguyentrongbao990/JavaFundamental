package Session12.Ex2;

public class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram > 0) {
            this.ram = ram;
        }
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        if (cpu != null && !cpu.trim().isEmpty()) {
            this.cpu = cpu;
        }
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8;
    }

    @Override
    public void displayInfo() {
        System.out.println("Loại tài sản: Computer");
        super.displayInfo();
        System.out.println("RAM: " + ram + " GB");
        System.out.println("CPU: " + cpu);
        System.out.println("Giá trị hiện tại: " + getMarketValue());
    }
}