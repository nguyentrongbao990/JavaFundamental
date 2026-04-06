package Session14.Ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập vào một số nguyên: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Lỗi: Số nhập vào phải lớn hơn 0 để kiểm tra số nguyên tố.");
            } else {
                if (isPrime(number)) {
                    System.out.println(number + " là số nguyên tố.");
                } else {
                    System.out.println(number + " không phải là số nguyên tố.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên hợp lệ.");
        } finally {
            scanner.close();
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}