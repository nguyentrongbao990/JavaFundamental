package Session12.Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Asset> assetList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=========== TECHASSET MANAGEMENT ===========");
            System.out.println("1. Nhập tài sản");
            System.out.println("2. Xuất báo cáo");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Sửa giá mua");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addAsset();
                    break;
                case "2":
                    reportAssets();
                    break;
                case "3":
                    searchMenu();
                    break;
                case "4":
                    updatePurchasePrice();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void addAsset() {
        System.out.println("\n--- NHẬP TÀI SẢN ---");
        System.out.println("1. Computer");
        System.out.println("2. Network Device");
        System.out.print("Chọn loại tài sản: ");

        String choice = scanner.nextLine().trim();

        String assetCode = inputAssetCode();
        if (searchAsset(assetCode) != null) {
            System.out.println("Mã tài sản đã tồn tại.");
            return;
        }

        String name = inputName();
        double purchasePrice = inputPurchasePrice();

        switch (choice) {
            case "1":
                int ram = inputRam();
                String cpu = inputCpu();

                Computer computer = new Computer(assetCode, name, purchasePrice, ram, cpu);
                assetList.add(computer);
                System.out.println("Đã thêm Computer.");
                break;

            case "2":
                int ports = inputNumberOfPorts();

                NetworkDevice device = new NetworkDevice(assetCode, name, purchasePrice, ports);
                assetList.add(device);
                System.out.println("Đã thêm Network Device.");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void reportAssets() {
        if (assetList.isEmpty()) {
            System.out.println("Danh sách tài sản trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH TÀI SẢN ---");
        for (Asset asset : assetList) {
            asset.displayInfo();
            System.out.println("--------------------------------");
        }
    }

    public static void searchMenu() {
        if (assetList.isEmpty()) {
            System.out.println("Danh sách tài sản trống.");
            return;
        }

        System.out.println("\n--- TÌM KIẾM TÀI SẢN ---");
        System.out.println("1. Tìm theo assetCode");
        System.out.println("2. Tìm theo purchasePrice");
        System.out.print("Lựa chọn của bạn: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Nhập mã tài sản cần tìm: ");
                String code = scanner.nextLine().trim();
                Asset found = searchAsset(code);
                if (found == null) {
                    System.out.println("Không tìm thấy tài sản.");
                } else {
                    found.displayInfo();
                }
                break;

            case "2":
                double minPrice = inputMinPrice();
                ArrayList<Asset> result = searchAsset(minPrice);

                if (result.isEmpty()) {
                    System.out.println("Không có tài sản nào có giá mua lớn hơn mức này.");
                } else {
                    System.out.println("Danh sách tài sản thỏa điều kiện:");
                    for (Asset asset : result) {
                        asset.displayInfo();
                        System.out.println("--------------------------------");
                    }
                }
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public static void updatePurchasePrice() {
        if (assetList.isEmpty()) {
            System.out.println("Danh sách tài sản trống.");
            return;
        }

        System.out.print("Nhập mã tài sản cần sửa giá mua: ");
        String code = scanner.nextLine().trim();

        Asset asset = searchAsset(code);
        if (asset == null) {
            System.out.println("Không tìm thấy tài sản.");
            return;
        }

        double newPrice = inputPurchasePrice();
        asset.setPurchasePrice(newPrice);
        System.out.println("Cập nhật giá mua thành công.");
        showValue(asset);
    }

    // Polymorphism
    public static void showValue(Asset a) {
        System.out.println("Tài sản: " + a.getName());
        System.out.println("Giá trị hiện tại: " + a.getMarketValue());
    }

    // Overloading
    public static Asset searchAsset(String assetCode) {
        for (Asset asset : assetList) {
            if (asset.getAssetCode().equalsIgnoreCase(assetCode)) {
                return asset;
            }
        }
        return null;
    }

    public static ArrayList<Asset> searchAsset(double minPurchasePrice) {
        ArrayList<Asset> result = new ArrayList<>();
        for (Asset asset : assetList) {
            if (asset.getPurchasePrice() > minPurchasePrice) {
                result.add(asset);
            }
        }
        return result;
    }

    private static String inputAssetCode() {
        while (true) {
            System.out.print("Nhập mã tài sản: ");
            String code = scanner.nextLine().trim();
            if (!code.isEmpty()) {
                return code;
            }
            System.out.println("Mã tài sản không được để trống.");
        }
    }

    private static String inputName() {
        while (true) {
            System.out.print("Nhập tên tài sản: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên tài sản không được để trống.");
        }
    }

    private static double inputPurchasePrice() {
        while (true) {
            try {
                System.out.print("Nhập giá mua: ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) {
                    return price;
                }
                System.out.println("Giá mua phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    private static double inputMinPrice() {
        while (true) {
            try {
                System.out.print("Nhập mức giá mua cần tìm lớn hơn: ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                if (price >= 0) {
                    return price;
                }
                System.out.println("Giá phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    private static int inputRam() {
        while (true) {
            try {
                System.out.print("Nhập RAM (GB): ");
                int ram = Integer.parseInt(scanner.nextLine().trim());
                if (ram > 0) {
                    return ram;
                }
                System.out.println("RAM phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static String inputCpu() {
        while (true) {
            System.out.print("Nhập CPU: ");
            String cpu = scanner.nextLine().trim();
            if (!cpu.isEmpty()) {
                return cpu;
            }
            System.out.println("CPU không được để trống.");
        }
    }

    private static int inputNumberOfPorts() {
        while (true) {
            try {
                System.out.print("Nhập số cổng: ");
                int ports = Integer.parseInt(scanner.nextLine().trim());
                if (ports > 0) {
                    return ports;
                }
                System.out.println("Số cổng phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }
}