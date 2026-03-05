package Session3;

import java.util.Scanner;

public class Ex1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ NHẬP THÔNG TIN HÓA ĐƠN ============");
        //Tên khách hàng
        System.out.print("Nhâp tên khách hàng: ");
        String name = sc.nextLine();
        //Sản phẩm
        System.out.print("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();
        //Giá
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(sc.nextLine());
        //Số lượng
        System.out.print("Nhập số lượng mua: ");
        int quantity = Integer.parseInt(sc.nextLine());
        //Thẻ thành viên
        System.out.print("Khách có thẻ thành viên? (true/false): ");
        boolean isMember = sc.nextBoolean();

        //output
        int thanhTien = price*quantity;
        int giamGia = (isMember)?thanhTien*10/100:0;
        int VAT = thanhTien*8/100;
        System.out.println("============ HÓA ĐƠN ============");
        System.out.println("Khách hàng:  " + name);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Đơn giá: "+price+" VNĐ");
        System.out.println("Số lượng: "+quantity);
        System.out.println("Thành tiền: "+thanhTien+" VNĐ");
        System.out.println("Giảm giá: "+giamGia+" VNĐ");
        System.out.println("tiền VAT: "+VAT+" VNĐ");
        System.out.println("Tổng tiền thanh toán: "+(thanhTien-giamGia+VAT)+" VNĐ");
    }
}
