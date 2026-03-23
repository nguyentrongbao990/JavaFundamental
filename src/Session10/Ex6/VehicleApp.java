package Session10.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota", 2020, "Gasoline"));
        vehicles.add(new Motorcycle("Honda", 2018, "Gasoline"));
        vehicles.add(new Truck("Volvo", 2022, "Diesel"));

        while (true) {
            System.out.println("========== VEHICLE MANAGEMENT MENU ==========");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (Vehicle array/list)");
            System.out.println("5. Gọi hành vi đặc trưng của từng loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát");
            System.out.println("=============================================");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                System.out.println();
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("--- THÔNG TIN PHƯƠNG TIỆN ---");
                    for (Vehicle v : vehicles) {
                        v.showInfo();
                        System.out.println("--------------------");
                    }
                    break;

                case 2:
                    System.out.println("--- OVERRIDING: startEngine() ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine();
                    }
                    break;

                case 3:
                    System.out.println("--- OVERLOADING: move() ---");
                    if (!vehicles.isEmpty()) {
                        Vehicle first = vehicles.get(0);
                        first.move();
                        first.move(80);
                    } else {
                        System.out.println("Danh sách phương tiện rỗng.");
                    }
                    break;

                case 4:
                    System.out.println("--- POLYMORPHISM RUNTIME ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine();
                    }
                    break;

                case 5:
                    System.out.println("--- HÀNH VI ĐẶC TRƯNG CỦA TỪNG LOẠI ---");
                    for (Vehicle v : vehicles) {
                        if (v instanceof Car) {
                            ((Car) v).openTrunk();
                        } else if (v instanceof Motorcycle) {
                            ((Motorcycle) v).doWheelie();
                        } else if (v instanceof Truck) {
                            ((Truck) v).loadCargo();
                        }
                    }
                    break;

                case 6:
                    System.out.println("--- THÊM PHƯƠNG TIỆN MỚI ---");
                    System.out.print("Loại (car/motorcycle/truck): ");
                    String type = sc.nextLine().trim().toLowerCase();

                    System.out.print("Brand: ");
                    String brand = sc.nextLine();

                    int year;
                    try {
                        System.out.print("Year: ");
                        year = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Year không hợp lệ.");
                        break;
                    }

                    System.out.print("Fuel Type: ");
                    String fuelType = sc.nextLine();

                    switch (type) {
                        case "car":
                            vehicles.add(new Car(brand, year, fuelType));
                            System.out.println("Đã thêm Car.");
                            break;
                        case "motorcycle":
                            vehicles.add(new Motorcycle(brand, year, fuelType));
                            System.out.println("Đã thêm Motorcycle.");
                            break;
                        case "truck":
                            vehicles.add(new Truck(brand, year, fuelType));
                            System.out.println("Đã thêm Truck.");
                            break;
                        default:
                            System.out.println("Loại phương tiện không hợp lệ.");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    sc.close();
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ.");
            }

            System.out.println();
        }
    }
}