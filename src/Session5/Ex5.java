package Session5;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "";

        while (true) {
            System.out.println("\n**************************** MENU ****************************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số, đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi (xóa khoảng trắng dư thừa, viết hoa chữ cái đầu)");
            System.out.println("6. Thoát");
            System.out.println("**************************************************************");
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
                    System.out.print("Nhập chuỗi: ");
                    str = input.nextLine();
                    break;

                case 2:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước.");
                        break;
                    }

                    int lower = 0, upper = 0, digit = 0, special = 0;
                    for (int i = 0; i < str.length(); i++) {
                        char ch = str.charAt(i);

                        if (Character.isLowerCase(ch)) {
                            lower++;
                        } else if (Character.isUpperCase(ch)) {
                            upper++;
                        } else if (Character.isDigit(ch)) {
                            digit++;
                        } else {
                            special++;
                        }
                    }

                    System.out.println("Số ký tự thường: " + lower);
                    System.out.println("Số ký tự hoa: " + upper);
                    System.out.println("Số chữ số: " + digit);
                    System.out.println("Số ký tự đặc biệt: " + special);
                    break;

                case 3:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước.");
                        break;
                    }

                    String reversed = new StringBuilder(str).reverse().toString();
                    System.out.println("Chuỗi đảo ngược: " + reversed);
                    break;

                case 4:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước.");
                        break;
                    }

                    String clean = str.replaceAll("\\s+", "").toLowerCase();
                    String reversedClean = new StringBuilder(clean).reverse().toString();

                    if (clean.equals(reversedClean)) {
                        System.out.println("Chuỗi là Palindrome.");
                    } else {
                        System.out.println("Chuỗi không phải Palindrome.");
                    }
                    break;

                case 5:
                    if (str.isEmpty()) {
                        System.out.println("Vui lòng nhập chuỗi trước.");
                        break;
                    }

                    String normalized = normalizeString(str);
                    System.out.println("Chuỗi sau khi chuẩn hóa: " + normalized);
                    break;

                case 6:
                    System.out.println("Tạm biệt!");
                    input.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static String normalizeString(String str) {
        str = str.trim().replaceAll("\\s+", " ").toLowerCase();

        if (str.isEmpty()) {
            return str;
        }

        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}