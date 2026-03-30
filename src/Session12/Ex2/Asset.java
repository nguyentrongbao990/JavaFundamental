package Session12.Ex2;

public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset() {
    }

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        if (assetCode != null && !assetCode.trim().isEmpty()) {
            this.assetCode = assetCode;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        if (purchasePrice > 0) {
            this.purchasePrice = purchasePrice;
        }
    }

    public abstract double getMarketValue();

    public void displayInfo() {
        System.out.println("Mã tài sản: " + assetCode);
        System.out.println("Tên tài sản: " + name);
        System.out.println("Giá mua: " + purchasePrice);
    }
}