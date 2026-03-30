package Session11.Ex6.ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    static {
        SDF.setLenient(false);
    }

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate, InvoiceDetail[] invoiceDetails, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        this.invoiceId = inputInvoiceId(scanner);
        this.customerName = inputCustomerName(scanner);
        this.invoiceDate = inputInvoiceDate(scanner);
        this.invoiceDetails = inputInvoiceDetails(scanner, arrProd, prodIndex);
        calculateTotalAmount();
    }

    public void updateData(Scanner scanner, Product[] arrProd, int prodIndex) {
        this.customerName = inputCustomerName(scanner);
        this.invoiceDate = inputInvoiceDate(scanner);
        this.invoiceDetails = inputInvoiceDetails(scanner, arrProd, prodIndex);
        calculateTotalAmount();
    }

    private String inputInvoiceId(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã hóa đơn (HDxxxx): ");
            String id = scanner.nextLine().trim().toUpperCase();
            if (id.matches("^HD\\d{4}$")) {
                return id;
            }
            System.out.println("Mã hóa đơn không đúng định dạng.");
        }
    }

    private String inputCustomerName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên khách hàng: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Tên khách hàng không được để trống.");
        }
    }

    private Date inputInvoiceDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập ngày lập hóa đơn (dd/MM/yyyy): ");
                return SDF.parse(scanner.nextLine().trim());
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ.");
            }
        }
    }

    private InvoiceDetail[] inputInvoiceDetails(Scanner scanner, Product[] arrProd, int prodIndex) {
        int availableCount = countAvailableProducts(arrProd, prodIndex);
        if (availableCount == 0) {
            System.out.println("Không có sản phẩm AVAILABLE để lập hóa đơn.");
            return new InvoiceDetail[0];
        }

        int n;
        while (true) {
            try {
                System.out.printf("Nhập số lượng loại sản phẩm trong hóa đơn (1-%d): ", availableCount);
                n = Integer.parseInt(scanner.nextLine().trim());
                if (n > 0 && n <= availableCount) {
                    break;
                }
                System.out.println("Số lượng không hợp lệ.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }

        InvoiceDetail[] details = new InvoiceDetail[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.println("Nhập chi tiết hóa đơn thứ " + (i + 1));
                InvoiceDetail detail = new InvoiceDetail();
                detail.inputData(scanner, arrProd, prodIndex);

                if (detail.getProduct() == null) {
                    System.out.println("Không thể chọn sản phẩm.");
                    continue;
                }

                if (isDuplicateProduct(detail.getProduct().getProductId(), details, i)) {
                    System.out.println("Sản phẩm đã có trong hóa đơn. Vui lòng chọn sản phẩm khác.");
                } else {
                    details[i] = detail;
                    break;
                }
            }
        }

        return details;
    }

    private int countAvailableProducts(Product[] arrProd, int prodIndex) {
        int count = 0;
        for (int i = 0; i < prodIndex; i++) {
            if (arrProd[i] != null && arrProd[i].getStatus() == ProductStatus.AVAILABLE) {
                count++;
            }
        }
        return count;
    }

    private boolean isDuplicateProduct(String productId, InvoiceDetail[] details, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (details[i] != null
                    && details[i].getProduct() != null
                    && details[i].getProduct().getProductId().equalsIgnoreCase(productId)) {
                return true;
            }
        }
        return false;
    }

    public void calculateTotalAmount() {
        double sum = 0;
        if (invoiceDetails != null) {
            for (InvoiceDetail detail : invoiceDetails) {
                if (detail != null) {
                    sum += detail.getSubTotal();
                }
            }
        }
        this.totalAmount = sum;
    }

    public void displayData() {
        System.out.println("====================================================");
        System.out.println("Mã hóa đơn: " + invoiceId);
        System.out.println("Tên khách hàng: " + customerName);
        System.out.println("Ngày lập: " + formatDate(invoiceDate));
        System.out.println("Chi tiết hóa đơn:");
        if (invoiceDetails == null || invoiceDetails.length == 0) {
            System.out.println("   Không có chi tiết hóa đơn.");
        } else {
            for (InvoiceDetail detail : invoiceDetails) {
                detail.displayData();
            }
        }
        System.out.printf("Tổng tiền: %.2f%n", totalAmount);
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return SDF.format(date);
    }
}