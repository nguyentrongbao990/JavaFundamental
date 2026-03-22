package Session8.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("===== MENU SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. In danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo khoảng giá");
            System.out.println("4. Thống kê số sản phẩm đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1:
                    Product p = new Product();
                    p.input(input);
                    products.add(p);
                    System.out.println("Đã thêm sản phẩm thành công.");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("Danh sách sản phẩm rỗng.");
                    } else {
                        for (int i = 0; i < products.size(); i++) {
                            System.out.println("Sản phẩm " + (i + 1) + ":");
                            products.get(i).print();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 3:
                    if (products.isEmpty()) {
                        System.out.println("Danh sách sản phẩm rỗng.");
                        break;
                    }

                    try {
                        System.out.print("Nhập giá thấp nhất: ");
                        double min = Double.parseDouble(input.nextLine());

                        System.out.print("Nhập giá cao nhất: ");
                        double max = Double.parseDouble(input.nextLine());

                        if (min > max) {
                            System.out.println("Khoảng giá không hợp lệ.");
                            break;
                        }

                        boolean found = false;
                        for (int i = 0; i < products.size(); i++) {
                            double price = products.get(i).getPrice();
                            if (price >= min && price <= max) {
                                products.get(i).print();
                                System.out.println("--------------------");
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá này.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Giá nhập vào không hợp lệ.");
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sản phẩm đã tạo: " + Product.getTotalProduct());
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    input.close();
                    return;

                default:
                    System.out.println("Lựa chọn phải từ 0 đến 4.");
            }
        }
    }
}