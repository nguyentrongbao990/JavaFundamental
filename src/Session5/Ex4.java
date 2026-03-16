package Session5;

import java.util.Random;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Nhập độ dài chuỗi ngẫu nhiên n (1 <= n <= 1000): ");
        int n = Integer.parseInt(input.nextLine());

        if (n < 1 || n > 1000) {
            System.out.println("n không hợp lệ");
            return;
        }

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result);

        input.close();
    }
}