package Session16.Ex1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        // Dữ liệu mẫu
        manager.addProduct(new Product(1, "Bánh mì", 20));
        manager.addProduct(new Product(2, "Khoai tây chiên", 20000));
        manager.addProduct(new Product(3, "Kẹo cốm", 50));

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            String choiceInput = scanner.nextLine();

            try {
                int choice = Integer.parseInt(choiceInput);

                switch (choice) {
                    case 1:
                        addProduct(scanner, manager);
                        break;
                    case 2:
                        editProduct(scanner, manager);
                        break;
                    case 3:
                        deleteProduct(scanner, manager);
                        break;
                    case 4:
                        manager.showProducts();
                        break;
                    case 5:
                        filterProducts(manager);
                        break;
                    case 6:
                        System.out.println("Total value of products: " + manager.getTotalValue());
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n--- Product Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display Products");
        System.out.println("5. Filter Products (Price > 100)");
        System.out.println("6. Total Value of Products");
        System.out.println("0. Exit");
    }

    public static void addProduct(Scanner scanner, ProductManager manager) {
        try {
            System.out.print("Enter Product ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Product Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (price <= 0) {
                System.out.println("Price must be greater than 0.");
                return;
            }

            Product product = new Product(id, name, price);
            boolean result = manager.addProduct(product);

            if (result) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Product ID already exists.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID hoặc Price không đúng định dạng số!");
        }
    }

    public static void editProduct(Scanner scanner, ProductManager manager) {
        try {
            System.out.print("Enter Product ID to edit: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter new Product Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new Product Price: ");
            double newPrice = Double.parseDouble(scanner.nextLine());

            if (newPrice <= 0) {
                System.out.println("Price must be greater than 0.");
                return;
            }

            boolean result = manager.updateProduct(id, newName, newPrice);

            if (result) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID hoặc Price không đúng định dạng số!");
        }
    }

    public static void deleteProduct(Scanner scanner, ProductManager manager) {
        try {
            System.out.print("Enter Product ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean result = manager.deleteProduct(id);

            if (result) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là số nguyên!");
        }
    }

    public static void filterProducts(ProductManager manager) {
        List<Product> filteredProducts = manager.filterProductsByPrice(100);

        if (filteredProducts.isEmpty()) {
            System.out.println("Không có sản phẩm nào có giá > 100.");
            return;
        }

        System.out.println("Products with price greater than 100:");
        filteredProducts.forEach(System.out::println);
    }
}