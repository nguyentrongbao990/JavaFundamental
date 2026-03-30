package Session11.Ex6.ra.presentation;

import Session11.Ex6.ra.entity.Invoice;
import Session11.Ex6.ra.entity.InvoiceDetail;
import Session11.Ex6.ra.entity.Product;
import Session11.Ex6.ra.entity.ProductStatus;

import java.util.Scanner;

public class InvoiceManagement {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MAX_PRODUCT = 100;
    private static final int MAX_INVOICE = 100;

    private static final Product[] products = new Product[MAX_PRODUCT];
    private static final Invoice[] invoices = new Invoice[MAX_INVOICE];

    private static int productCount = 0;
    private static int invoiceCount = 0;

    public static void main(String[] args) {
        do {
            System.out.println("\n================ QUẢN LÝ HÓA ĐƠN ================");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Báo cáo doanh thu");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    productMenu();
                    break;
                case "2":
                    invoiceMenu();
                    break;
                case "3":
                    revenueReport();
                    break;
                case "4":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 4.");
            }
        } while (true);
    }

    private static void productMenu() {
        do {
            System.out.println("\n================ QUẢN LÝ SẢN PHẨM ================");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm (nếu chưa có trong hóa đơn nào)");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    displayProducts();
                    break;
                case "3":
                    updateProduct();
                    break;
                case "4":
                    deleteProduct();
                    break;
                case "5":
                    searchProductByName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 6.");
            }
        } while (true);
    }

    private static void invoiceMenu() {
        do {
            System.out.println("\n================ QUẢN LÝ HÓA ĐƠN ================");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Cập nhật thông tin hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Tìm hóa đơn theo mã");
            System.out.println("6. Tìm hóa đơn theo tên khách hàng");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addInvoice();
                    break;
                case "2":
                    displayInvoices();
                    break;
                case "3":
                    updateInvoice();
                    break;
                case "4":
                    deleteInvoice();
                    break;
                case "5":
                    searchInvoiceById();
                    break;
                case "6":
                    searchInvoiceByCustomerName();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 7.");
            }
        } while (true);
    }

    // ======================= PRODUCT =======================

    private static void addProduct() {
        if (productCount == MAX_PRODUCT) {
            System.out.println("Danh sách sản phẩm đã đầy.");
            return;
        }

        Product product = new Product();
        product.inputData(scanner, products, productCount);
        products[productCount++] = product;
        System.out.println("Thêm sản phẩm thành công.");
    }

    private static void displayProducts() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.println("\n--------- DANH SÁCH SẢN PHẨM ---------");
        for (int i = 0; i < productCount; i++) {
            products[i].displayData();
        }
    }

    private static void updateProduct() {
        int index = findProductIndexById(inputProductIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }

        Product product = products[index];

        String newName;
        while (true) {
            System.out.print("Nhập tên mới (10-50 ký tự, duy nhất): ");
            newName = scanner.nextLine().trim();

            if (newName.length() < 10 || newName.length() > 50) {
                System.out.println("Tên sản phẩm không hợp lệ.");
                continue;
            }

            if (isDuplicateProductName(newName, index)) {
                System.out.println("Tên sản phẩm đã tồn tại.");
                continue;
            }
            break;
        }
        product.setProductName(newName);

        while (true) {
            try {
                System.out.print("Nhập giá mới (>0): ");
                double price = Double.parseDouble(scanner.nextLine().trim());
                if (price > 0) {
                    product.setPrice(price);
                    break;
                }
                System.out.println("Giá phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }

        product.setStatus(inputProductStatus());
        System.out.println("Cập nhật sản phẩm thành công.");
    }

    private static void deleteProduct() {
        int index = findProductIndexById(inputProductIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }

        if (isProductInAnyInvoice(products[index].getProductId())) {
            System.out.println("Không thể xóa vì sản phẩm đã tồn tại trong hóa đơn.");
            return;
        }

        for (int i = index; i < productCount - 1; i++) {
            products[i] = products[i + 1];
        }
        products[productCount - 1] = null;
        productCount--;

        System.out.println("Xóa sản phẩm thành công.");
    }

    private static void searchProductByName() {
        if (productCount == 0) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductName().toLowerCase().contains(keyword)) {
                products[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm phù hợp.");
        }
    }

    // ======================= INVOICE =======================

    private static void addInvoice() {
        if (invoiceCount == MAX_INVOICE) {
            System.out.println("Danh sách hóa đơn đã đầy.");
            return;
        }

        if (countAvailableProducts() == 0) {
            System.out.println("Không có sản phẩm AVAILABLE để lập hóa đơn.");
            return;
        }

        while (true) {
            Invoice invoice = new Invoice();
            invoice.inputData(scanner, products, productCount);

            if (findInvoiceIndexById(invoice.getInvoiceId()) != -1) {
                System.out.println("Mã hóa đơn đã tồn tại. Vui lòng nhập lại.");
            } else {
                invoices[invoiceCount++] = invoice;
                System.out.println("Thêm hóa đơn thành công.");
                break;
            }
        }
    }

    private static void displayInvoices() {
        if (invoiceCount == 0) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }

        System.out.println("\n--------- DANH SÁCH HÓA ĐƠN ---------");
        for (int i = 0; i < invoiceCount; i++) {
            invoices[i].displayData();
        }
    }

    private static void updateInvoice() {
        int index = findInvoiceIndexById(inputInvoiceIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn.");
            return;
        }

        if (countAvailableProducts() == 0) {
            System.out.println("Không có sản phẩm AVAILABLE để cập nhật hóa đơn.");
            return;
        }

        invoices[index].updateData(scanner, products, productCount);
        System.out.println("Cập nhật hóa đơn thành công.");
    }

    private static void deleteInvoice() {
        int index = findInvoiceIndexById(inputInvoiceIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn.");
            return;
        }

        for (int i = index; i < invoiceCount - 1; i++) {
            invoices[i] = invoices[i + 1];
        }
        invoices[invoiceCount - 1] = null;
        invoiceCount--;

        System.out.println("Xóa hóa đơn thành công.");
    }

    private static void searchInvoiceById() {
        int index = findInvoiceIndexById(inputInvoiceIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy hóa đơn.");
            return;
        }

        invoices[index].displayData();
    }

    private static void searchInvoiceByCustomerName() {
        if (invoiceCount == 0) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }

        System.out.print("Nhập tên khách hàng cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < invoiceCount; i++) {
            if (invoices[i].getCustomerName().toLowerCase().contains(keyword)) {
                invoices[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy hóa đơn phù hợp.");
        }
    }

    // ======================= REVENUE REPORT =======================

    private static void revenueReport() {
        if (invoiceCount == 0) {
            System.out.println("Chưa có hóa đơn nào.");
            return;
        }

        double totalRevenue = 0;
        Invoice maxInvoice = invoices[0];

        for (int i = 0; i < invoiceCount; i++) {
            totalRevenue += invoices[i].getTotalAmount();
            if (invoices[i].getTotalAmount() > maxInvoice.getTotalAmount()) {
                maxInvoice = invoices[i];
            }
        }

        System.out.println("\n================ BÁO CÁO DOANH THU ================");
        System.out.println("Tổng số hóa đơn: " + invoiceCount);
        System.out.printf("Tổng doanh thu: %.2f%n", totalRevenue);
        System.out.printf("Doanh thu trung bình / hóa đơn: %.2f%n", totalRevenue / invoiceCount);
        System.out.println("Hóa đơn có giá trị lớn nhất: " + maxInvoice.getInvoiceId()
                + " | Khách hàng: " + maxInvoice.getCustomerName()
                + " | Tổng tiền: " + String.format("%.2f", maxInvoice.getTotalAmount()));

        System.out.println("\nDoanh thu theo ngày:");
        boolean[] visited = new boolean[invoiceCount];
        for (int i = 0; i < invoiceCount; i++) {
            if (!visited[i]) {
                String dateStr = Invoice.formatDate(invoices[i].getInvoiceDate());
                double sumByDate = 0;

                for (int j = i; j < invoiceCount; j++) {
                    if (!visited[j] && Invoice.formatDate(invoices[j].getInvoiceDate()).equals(dateStr)) {
                        sumByDate += invoices[j].getTotalAmount();
                        visited[j] = true;
                    }
                }

                System.out.printf("- %s : %.2f%n", dateStr, sumByDate);
            }
        }
    }

    // ======================= HELPER =======================

    private static int findProductIndexById(String productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId().equalsIgnoreCase(productId)) {
                return i;
            }
        }
        return -1;
    }

    private static int findInvoiceIndexById(String invoiceId) {
        for (int i = 0; i < invoiceCount; i++) {
            if (invoices[i].getInvoiceId().equalsIgnoreCase(invoiceId)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isDuplicateProductName(String productName, int currentIndex) {
        for (int i = 0; i < productCount; i++) {
            if (i != currentIndex && products[i].getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isProductInAnyInvoice(String productId) {
        for (int i = 0; i < invoiceCount; i++) {
            InvoiceDetail[] details = invoices[i].getInvoiceDetails();
            if (details != null) {
                for (InvoiceDetail detail : details) {
                    if (detail != null
                            && detail.getProduct() != null
                            && detail.getProduct().getProductId().equalsIgnoreCase(productId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int countAvailableProducts() {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getStatus() == ProductStatus.AVAILABLE) {
                count++;
            }
        }
        return count;
    }

    private static String inputProductIdToFind() {
        System.out.print("Nhập mã sản phẩm: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    private static String inputInvoiceIdToFind() {
        System.out.print("Nhập mã hóa đơn: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    private static ProductStatus inputProductStatus() {
        while (true) {
            System.out.println("Chọn trạng thái sản phẩm:");
            System.out.println("1. AVAILABLE");
            System.out.println("2. OUT_OF_STOCK");
            System.out.println("3. STOP_SELLING");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return ProductStatus.AVAILABLE;
                case "2":
                    return ProductStatus.OUT_OF_STOCK;
                case "3":
                    return ProductStatus.STOP_SELLING;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}