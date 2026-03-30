package Session12.Ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Drink> menuList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=========== COFFEESHOP PRO ===========");
            System.out.println("1. Thêm món vào Menu");
            System.out.println("2. Hiển thị Menu");
            System.out.println("3. Áp dụng mã giảm giá");
            System.out.println("4. Xóa món");
            System.out.println("5. Thống kê");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addDrink();
                    break;
                case "2":
                    displayMenu();
                    break;
                case "3":
                    applyPromotion();
                    break;
                case "4":
                    deleteDrink();
                    break;
                case "5":
                    statistics();
                    break;
                case "6":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addDrink() {
        System.out.println("\n--- THÊM MÓN ---");
        System.out.println("1. Coffee");
        System.out.println("2. Fruit Tea");
        System.out.print("Chọn loại đồ uống: ");
        String choice = scanner.nextLine().trim();

        String id = inputId();
        if (findById(id) != null) {
            System.out.println("Mã món đã tồn tại.");
            return;
        }

        String name = inputName();
        double price = inputPrice();

        switch (choice) {
            case "1":
                menuList.add(new Coffee(id, name, price));
                System.out.println("Đã thêm Coffee vào menu.");
                break;
            case "2":
                menuList.add(new FruitTea(id, name, price));
                System.out.println("Đã thêm Fruit Tea vào menu.");
                break;
            default:
                System.out.println("Loại đồ uống không hợp lệ.");
        }
    }

    private static void displayMenu() {
        if (menuList.isEmpty()) {
            System.out.println("Menu đang trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH ĐỒ UỐNG ---");
        for (Drink drink : menuList) {
            drink.displayInfo();
            System.out.println("--------------------------------");
        }
    }

    private static void applyPromotion() {
        if (menuList.isEmpty()) {
            System.out.println("Menu đang trống.");
            return;
        }

        double percentage = inputDiscountPercentage();

        for (Drink drink : menuList) {
            if (drink instanceof IPromotion) {
                ((IPromotion) drink).applyDiscount(percentage);
            }
        }

        System.out.println("Áp dụng giảm giá thành công cho toàn bộ menu.");
    }

    private static void deleteDrink() {
        if (menuList.isEmpty()) {
            System.out.println("Menu đang trống.");
            return;
        }

        System.out.print("Nhập mã món cần xóa: ");
        String id = scanner.nextLine().trim();

        Drink drink = findById(id);
        if (drink == null) {
            System.out.println("Không tìm thấy món.");
            return;
        }

        menuList.remove(drink);
        System.out.println("Xóa món thành công.");
    }

    private static void statistics() {
        if (menuList.isEmpty()) {
            System.out.println("Menu đang trống.");
            return;
        }

        double total = 0;
        for (Drink drink : menuList) {
            total += drink.getPrice();
        }

        System.out.println("\n--- THỐNG KÊ MENU ---");
        System.out.println("Tổng số món: " + menuList.size());
        System.out.printf("Tổng giá trị menu: %.2f%n", total);
        System.out.printf("Giá trung bình: %.2f%n", total / menuList.size());
    }

    private static Drink findById(String id) {
        for (Drink drink : menuList) {
            if (drink.getId().equalsIgnoreCase(id)) {
                return drink;
            }
        }
        return null;
    }

    private static String inputId() {
        while (true) {
            System.out.print("Nhập mã món: ");
            String id = scanner.nextLine().trim();
            if (!id.isEmpty()) {
                return id;
            }
            System.out.println("Mã món không được để trống.");
        }
    }

    private static String inputName() {
        while (true) {
            System.out.print("Nhập tên món: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên món không được để trống.");
        }
    }

    private static double inputPrice() {
        while (true) {
            try {
                System.out.print("Nhập giá món: ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) {
                    return price;
                }
                System.out.println("Giá phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    private static double inputDiscountPercentage() {
        while (true) {
            try {
                System.out.print("Nhập phần trăm giảm giá: ");
                double percentage = Double.parseDouble(scanner.nextLine().trim());
                if (percentage > 0 && percentage <= 100) {
                    return percentage;
                }
                System.out.println("Phần trăm giảm giá phải từ 0 đến 100.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }
}