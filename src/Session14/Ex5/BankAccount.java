package Session14.Ex5;

import java.util.List;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Số tiền gửi phải lớn hơn 0!");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Số tiền rút phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new Exception("Số dư không đủ để rút!");
        }
        balance -= amount;
    }

    public void transfer(BankAccount targetAccount, double amount) throws Exception {
        if (targetAccount == null) {
            throw new Exception("Tài khoản đích không tồn tại!");
        }
        if (amount <= 0) {
            throw new Exception("Số tiền chuyển phải lớn hơn 0!");
        }
        if (amount > balance) {
            throw new Exception("Số dư không đủ để chuyển!");
        }

        this.balance -= amount;
        targetAccount.balance += amount;
    }

    public static BankAccount findAccountById(List<BankAccount> accounts, String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tài khoản: " + accountId + " | Số dư: " + balance;
    }
}