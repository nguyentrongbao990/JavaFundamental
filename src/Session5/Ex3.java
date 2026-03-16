package Session5;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập mật khẩu cần kiểm tra: ");
        String password = input.nextLine();

        // Regex kiểm tra:
        // (?=.*[a-z])      : có ít nhất 1 chữ thường
        // (?=.*[A-Z])      : có ít nhất 1 chữ hoa
        // (?=.*\\d)        : có ít nhất 1 chữ số
        // (?=.*[^A-Za-z0-9]): có ít nhất 1 ký tự đặc biệt
        // .{8,}            : ít nhất 8 ký tự
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

        if (password.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }

        input.close();
    }
}