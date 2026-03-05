package Session2;

import java.util.Scanner;

public class Ex6 {
    static int digitCount(int n){
        if(n==0){
            return 1;
        }
        int count = 0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
    static int intPow(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }
    static boolean isArmstrong(int n) {
        int k = digitCount(n);
        int temp = n;
        int sum = 0;

        if (temp == 0) return true;

        while (temp > 0) {
            int digit = temp % 10;
            sum += intPow(digit, k);
            temp /= 10;

            // cắt sớm: nếu sum đã vượt n thì khỏi tính tiếp (tối ưu nhỏ)
            if (sum > n) return false;
        }
        return sum == n;
    }
    static int readNonNegativeInt(Scanner sc) {
        while (true) {
            System.out.print("Nhập N: ");
            if (!sc.hasNextInt()) {
                System.out.println("Số nhập vào không hợp lệ.");
                sc.next(); // nuốt token sai
                continue;
            }
            int n = sc.nextInt();
            if (n < 0) {
                System.out.println("Số nhập vào không hợp lệ.");
                continue;
            }
            return n;
        }
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readNonNegativeInt(sc);

        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }

        sc.close();
    }
}
