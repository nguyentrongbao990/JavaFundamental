package Session14.Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputStrings = new ArrayList<>();
        ArrayList<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;
        System.out.println("Nhập các chuỗi (gõ \"exit\" để kết thúc):");
        //Nhập danh sách chuỗi
        while (true) {
            System.out.print("Nhập chuỗi: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            inputStrings.add(input);
        }
        //Duyệt danh sách và chuyển đổi sang số nguyên
        for (String str : inputStrings) {
            try {
                int number = Integer.parseInt(str);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }
        //Hiển thị kết quả
        System.out.println("\nSố chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);
    }
}