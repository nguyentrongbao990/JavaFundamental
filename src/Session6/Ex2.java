package Session6;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String fullName = "";
        String email = "";
        String phone = "";
        String password = "";

        while (true) {
            System.out.println("\n******************** QUẢN LÝ NGƯỜI DÙNG ********************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
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
                    System.out.print("Nhập họ và tên: ");
                    fullName = input.nextLine();

                    System.out.print("Nhập email: ");
                    email = input.nextLine().trim();

                    System.out.print("Nhập số điện thoại: ");
                    phone = input.nextLine().trim();

                    System.out.print("Nhập mật khẩu: ");
                    password = input.nextLine();

                    System.out.println("Đã nhập thông tin người dùng.");
                    break;

                case 2:
                    if (fullName.isEmpty()) {
                        System.out.println("Chưa có họ tên. Vui lòng nhập thông tin trước.");
                    } else {
                        String normalizedName = normalizeName(fullName);
                        System.out.println("Họ tên sau khi chuẩn hóa: " + normalizedName);
                    }
                    break;

                case 3:
                    if (email.isEmpty()) {
                        System.out.println("Chưa có email. Vui lòng nhập thông tin trước.");
                    } else {
                        if (isValidEmail(email)) {
                            System.out.println("Email hợp lệ.");
                        } else {
                            System.out.println("Email không hợp lệ.");
                        }
                    }
                    break;

                case 4:
                    if (phone.isEmpty()) {
                        System.out.println("Chưa có số điện thoại. Vui lòng nhập thông tin trước.");
                    } else {
                        if (isValidPhone(phone)) {
                            System.out.println("Số điện thoại hợp lệ.");
                        } else {
                            System.out.println("Số điện thoại không hợp lệ.");
                        }
                    }
                    break;

                case 5:
                    if (password.isEmpty()) {
                        System.out.println("Chưa có mật khẩu. Vui lòng nhập thông tin trước.");
                    } else {
                        if (isValidPassword(password)) {
                            System.out.println("Mật khẩu hợp lệ.");
                        } else {
                            System.out.println("Mật khẩu không hợp lệ.");
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

    public static String normalizeName(String name) {
        name = name.trim().replaceAll("\\s+", " ").toLowerCase();

        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                if (words[i].length() > 1) {
                    sb.append(words[i].substring(1));
                }
                if (i < words.length - 1) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^(03|05|07|08|09)\\d{8}$");
    }

    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }
}