package Session14.Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> validPhones = new ArrayList<>();
        List<String> invalidPhones = new ArrayList<>();

        System.out.print("Nhập danh sách số điện thoại, cách nhau bởi dấu phẩy: ");
        String input = scanner.nextLine();

        String[] phoneNumbers = input.split(",");

        for (String phone : phoneNumbers) {
            phone = phone.trim();

            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.add(phone + " : " + e.getMessage());
            }
        }

        System.out.println("\nSố điện thoại hợp lệ:");
        if (validPhones.isEmpty()) {
            System.out.println("Không có số điện thoại hợp lệ.");
        } else {
            for (String phone : validPhones) {
                System.out.println("- " + phone);
            }
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        if (invalidPhones.isEmpty()) {
            System.out.println("Không có số điện thoại không hợp lệ.");
        } else {
            for (String phone : invalidPhones) {
                System.out.println("- " + phone);
            }
        }

        scanner.close();
    }
}