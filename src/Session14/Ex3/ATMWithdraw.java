package Session14.Ex3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMWithdraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000000;
        double minBalance = 50000;

        try {
            System.out.print("Nhập số tiền muốn rút: ");
            double withdrawAmount = scanner.nextDouble();

            if (withdrawAmount <= 0) {
                System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
            } else if (withdrawAmount > balance) {
                System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
            } else if (balance - withdrawAmount < minBalance) {
                System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            } else {
                balance -= withdrawAmount;
                System.out.println("Rút tiền thành công!");
                System.out.println("Số tiền đã rút: " + withdrawAmount + " đồng");
                System.out.println("Số dư còn lại: " + balance + " đồng");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
        } finally {
            scanner.close();
        }
    }
}