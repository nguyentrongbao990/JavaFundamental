package Session11.Ex6.ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private ProductStatus status;

    public Product() {
    }

    public Product(String productId, String productName, double price, ProductStatus status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int index) {
        this.productId = inputProductId(scanner, arrProd, index);
        this.productName = inputProductName(scanner, arrProd, index);
        this.price = inputPrice(scanner);
        this.status = inputStatus(scanner);
    }

    private String inputProductId(Scanner scanner, Product[] arrProd, int index) {
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx / Sxxx / Axxx): ");
            String id = scanner.nextLine().trim().toUpperCase();

            if (!id.matches("^[CSA]\\d{3}$")) {
                System.out.println("Mã sản phẩm không đúng định dạng.");
                continue;
            }

            boolean existed = false;
            for (int i = 0; i < index; i++) {
                if (arrProd[i] != null && arrProd[i].getProductId().equalsIgnoreCase(id)) {
                    existed = true;
                    break;
                }
            }

            if (existed) {
                System.out.println("Mã sản phẩm đã tồn tại.");
            } else {
                return id;
            }
        }
    }

    private String inputProductName(Scanner scanner, Product[] arrProd, int index) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự, duy nhất): ");
            String name = scanner.nextLine().trim();

            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên sản phẩm phải từ 10 đến 50 ký tự.");
                continue;
            }

            boolean existed = false;
            for (int i = 0; i < index; i++) {
                if (arrProd[i] != null && arrProd[i].getProductName().equalsIgnoreCase(name)) {
                    existed = true;
                    break;
                }
            }

            if (existed) {
                System.out.println("Tên sản phẩm đã tồn tại.");
            } else {
                return name;
            }
        }
    }

    private double inputPrice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập giá bán (>0): ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) {
                    return price;
                }
                System.out.println("Giá bán phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    private ProductStatus inputStatus(Scanner scanner) {
        while (true) {
            System.out.println("Chọn trạng thái sản phẩm:");
            System.out.println("1. AVAILABLE");
            System.out.println("2. OUT_OF_STOCK");
            System.out.println("3. STOP_SELLING");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return ProductStatus.AVAILABLE;
                case "2":
                    return ProductStatus.OUT_OF_STOCK;
                case "3":
                    return ProductStatus.STOP_SELLING;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void displayData() {
        System.out.printf("Mã SP: %s | Tên SP: %s | Giá: %.2f | Trạng thái: %s%n",
                productId, productName, price, status);
    }
}