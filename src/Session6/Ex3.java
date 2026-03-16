package Session6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> plates = new ArrayList<>();

        while (true) {
            System.out.println("\n******************** QUẢN LÝ BIỂN SỐ XE ********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng biển số xe muốn thêm: ");
                    int n;
                    try {
                        n = Integer.parseInt(input.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Số lượng không hợp lệ.");
                        break;
                    }

                    if (n <= 0) {
                        System.out.println("Số lượng phải lớn hơn 0.");
                        break;
                    }

                    for (int i = 0; i < n; i++) {
                        while (true) {
                            System.out.print("Nhập biển số xe thứ " + (i + 1) + ": ");
                            String plate = input.nextLine().trim().toUpperCase();

                            if (!isValidPlate(plate)) {
                                System.out.println("Biển số không đúng định dạng. Ví dụ hợp lệ: 30F-123.45");
                                continue;
                            }

                            if (plates.contains(plate)) {
                                System.out.println("Biển số đã tồn tại. Nhập biển số khác.");
                                continue;
                            }

                            plates.add(plate);
                            break;
                        }
                    }
                    System.out.println("Đã thêm thành công.");
                    break;

                case 2:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số xe đang trống.");
                    } else {
                        System.out.println("Danh sách biển số xe:");
                        for (int i = 0; i < plates.size(); i++) {
                            System.out.println((i + 1) + ". " + plates.get(i));
                        }
                    }
                    break;

                case 3:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số xe đang trống.");
                        break;
                    }

                    System.out.print("Nhập biển số cần tìm: ");
                    String searchPlate = input.nextLine().trim().toUpperCase();

                    int index = linearSearch(plates, searchPlate);
                    if (index == -1) {
                        System.out.println("Không tìm thấy biển số xe.");
                    } else {
                        System.out.println("Tìm thấy biển số xe tại vị trí " + (index + 1) + ": " + plates.get(index));
                    }
                    break;

                case 4:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số xe đang trống.");
                        break;
                    }

                    System.out.print("Nhập mã tỉnh cần tìm (ví dụ: 30, 51, 16): ");
                    String provinceCode = input.nextLine().trim();

                    if (!provinceCode.matches("\\d{2}")) {
                        System.out.println("Mã tỉnh không hợp lệ. Mã tỉnh phải gồm 2 chữ số.");
                        break;
                    }

                    boolean found = false;
                    System.out.println("Các biển số thuộc mã tỉnh " + provinceCode + ":");
                    for (String plate : plates) {
                        if (plate.startsWith(provinceCode)) {
                            System.out.println("- " + plate);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không có biển số nào thuộc mã tỉnh này.");
                    }
                    break;

                case 5:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách biển số xe đang trống.");
                    } else {
                        Collections.sort(plates);
                        System.out.println("Đã sắp xếp biển số xe tăng dần.");
                        System.out.println("Danh sách sau khi sắp xếp:");
                        for (int i = 0; i < plates.size(); i++) {
                            System.out.println((i + 1) + ". " + plates.get(i));
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    input.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static boolean isValidPlate(String plate) {
        return plate.matches("^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$");
    }

    public static int linearSearch(ArrayList<String> plates, String target) {
        for (int i = 0; i < plates.size(); i++) {
            if (plates.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
}