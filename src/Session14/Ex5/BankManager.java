package Session14.Ex5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("A001", 500000));
        accounts.add(new BankAccount("A002", 1000000));
        accounts.add(new BankAccount("A003", 2000000));

        try {
            System.out.println("===== DANH SÁCH TÀI KHOẢN BAN ĐẦU =====");
            for (BankAccount account : accounts) {
                System.out.println(account);
            }

            System.out.println("\n===== GỬI TIỀN =====");
            System.out.print("Nhập số tài khoản cần gửi tiền: ");
            String depositId = scanner.nextLine();

            BankAccount depositAccount = BankAccount.findAccountById(accounts, depositId);
            if (depositAccount == null) {
                System.out.println("Lỗi: Tài khoản không tồn tại!");
            } else {
                System.out.print("Nhập số tiền cần gửi: ");
                double depositAmount = scanner.nextDouble();
                depositAccount.deposit(depositAmount);
                System.out.println("Gửi tiền thành công!");
                System.out.println(depositAccount);
            }

            scanner.nextLine();

            System.out.println("\n===== RÚT TIỀN =====");
            System.out.print("Nhập số tài khoản cần rút tiền: ");
            String withdrawId = scanner.nextLine();

            BankAccount withdrawAccount = BankAccount.findAccountById(accounts, withdrawId);
            if (withdrawAccount == null) {
                System.out.println("Lỗi: Tài khoản không tồn tại!");
            } else {
                System.out.print("Nhập số tiền cần rút: ");
                double withdrawAmount = scanner.nextDouble();
                withdrawAccount.withdraw(withdrawAmount);
                System.out.println("Rút tiền thành công!");
                System.out.println(withdrawAccount);
            }

            scanner.nextLine();

            System.out.println("\n===== CHUYỂN TIỀN =====");
            System.out.print("Nhập tài khoản nguồn: ");
            String sourceId = scanner.nextLine();

            System.out.print("Nhập tài khoản đích: ");
            String targetId = scanner.nextLine();

            BankAccount sourceAccount = BankAccount.findAccountById(accounts, sourceId);
            BankAccount targetAccount = BankAccount.findAccountById(accounts, targetId);

            if (sourceAccount == null) {
                System.out.println("Lỗi: Tài khoản nguồn không tồn tại!");
            } else {
                System.out.print("Nhập số tiền cần chuyển: ");
                double transferAmount = scanner.nextDouble();

                sourceAccount.transfer(targetAccount, transferAmount);
                System.out.println("Chuyển tiền thành công!");
                System.out.println("Tài khoản nguồn sau chuyển: " + sourceAccount);
                System.out.println("Tài khoản đích sau nhận: " + targetAccount);
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập đúng kiểu số!");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            System.out.println("\n===== DANH SÁCH TÀI KHOẢN CUỐI CÙNG =====");
            for (BankAccount account : accounts) {
                System.out.println(account);
            }
            scanner.close();
        }
    }
}