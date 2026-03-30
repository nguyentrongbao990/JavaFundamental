package Session11.Ex6.ra.entity;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        this.product = inputProduct(scanner, arrProd, prodIndex);
        this.quantity = inputQuantity(scanner);
        this.subTotal = this.product.getPrice() * this.quantity;
    }

    private Product inputProduct(Scanner scanner, Product[] arrProd, int prodIndex) {
        System.out.println("Danh sách sản phẩm có thể chọn:");
        boolean hasAvailable = false;
        for (int i = 0; i < prodIndex; i++) {
            if (arrProd[i] != null && arrProd[i].getStatus() == ProductStatus.AVAILABLE) {
                arrProd[i].displayData();
                hasAvailable = true;
            }
        }

        if (!hasAvailable) {
            return null;
        }

        while (true) {
            System.out.print("Nhập mã sản phẩm muốn mua: ");
            String productId = scanner.nextLine().trim().toUpperCase();

            for (int i = 0; i < prodIndex; i++) {
                if (arrProd[i] != null
                        && arrProd[i].getProductId().equalsIgnoreCase(productId)
                        && arrProd[i].getStatus() == ProductStatus.AVAILABLE) {
                    return arrProd[i];
                }
            }

            System.out.println("Sản phẩm không tồn tại hoặc không ở trạng thái AVAILABLE.");
        }
    }

    private int inputQuantity(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập số lượng mua (>0): ");
                int quantity = Integer.parseInt(scanner.nextLine().trim());
                if (quantity > 0) {
                    return quantity;
                }
                System.out.println("Số lượng phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    public void displayData() {
        if (product != null) {
            System.out.printf("   - Mã SP: %s | Tên SP: %s | Số lượng: %d | Thành tiền: %.2f%n",
                    product.getProductId(), product.getProductName(), quantity, subTotal);
        }
    }
}