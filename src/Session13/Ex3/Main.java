package Session13.Ex3;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InvoiceManager manager = new InvoiceManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*************** MENU QUẢN LÝ HÓA ĐƠN ***************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addInvoice();
                    break;
                case "2":
                    updateInvoice();
                    break;
                case "3":
                    deleteInvoice();
                    break;
                case "4":
                    displayInvoices();
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5.");
            }
        }
    }

    private static void addInvoice() {
        int id = inputPositiveInt("Nhập id hóa đơn: ");

        if (manager.isDuplicateId(id)) {
            System.out.println("ID hóa đơn đã tồn tại.");
            return;
        }

        String invoiceCode = inputInvoiceCode("Nhập mã hóa đơn: ");
        double amount = inputAmount("Nhập số tiền: ");

        Invoice invoice = new Invoice(id, invoiceCode, amount);
        manager.add(invoice);

        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    private static void updateInvoice() {
        if (manager.size() == 0) {
            System.out.println("Danh sách hóa đơn đang trống.");
            return;
        }

        manager.display();
        int id = inputPositiveInt("Nhập id hóa đơn cần sửa: ");
        int index = manager.findIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
            return;
        }

        String newInvoiceCode = inputInvoiceCode("Nhập mã hóa đơn mới: ");
        double newAmount = inputAmount("Nhập số tiền mới: ");

        Invoice updatedInvoice = new Invoice(id, newInvoiceCode, newAmount);
        manager.update(index, updatedInvoice);

        System.out.println("Hóa đơn đã được sửa thành công.");
    }

    private static void deleteInvoice() {
        if (manager.size() == 0) {
            System.out.println("Danh sách hóa đơn đang trống.");
            return;
        }

        manager.display();
        int id = inputPositiveInt("Nhập id hóa đơn cần xóa: ");
        int index = manager.findIndexById(id);

        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn nào có id = " + id);
            return;
        }

        manager.delete(index);
        System.out.println("Hóa đơn đã được xóa thành công.");
    }

    private static void displayInvoices() {
        manager.display();
    }

    private static int inputPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Vui lòng nhập số nguyên > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static String inputInvoiceCode(String message) {
        while (true) {
            System.out.print(message);
            String code = scanner.nextLine().trim();
            if (!code.isEmpty()) {
                return code;
            }
            System.out.println("Vui lòng không để trống!");
        }
    }

    private static double inputAmount(String message) {
        while (true) {
            try {
                System.out.print(message);
                double amount = Double.parseDouble(scanner.nextLine().trim());
                if (amount >= 0) {
                    return amount;
                }
                System.out.println("Vui lòng nhập số thực >= 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }
    }
}