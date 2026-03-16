package BaiTapTrenLop.Ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerManager {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Customer customer1 = new Customer();
        customer1.setMaKhachHang("01");
        customer1.setHoTen("NguyenVanB");
        customer1.setGioiTinh("Nam");
        customer1.setNgaySinh(LocalDate.parse("01/01/2024",dtf));
        customer1.setQueQuan("Ha Noi");
        customer1.setSoDienThoai("0123456789");
        customer1.setEmail("nguyenvanb@gmail.com");
        Customer customer2 = new Customer("02","Nguyen Van B","Nam", LocalDate.parse("02/02/2005",dtf),"Hai Phong","0987654321","nguyenvana@gmail.con");

        //Hiển thị thông tin customer1
        System.out.println("Thông tin khách hàng 1:");
        System.out.println("Mã khách hàng: " + customer1.getMaKhachHang());
        System.out.println("Họ tên: " + customer1.getHoTen());
        System.out.println("Giới tính: " + customer1.getGioiTinh());
        System.out.println("Ngày sinh: " + customer1.getNgaySinh().format(dtf));
        System.out.println("Quê quán: " + customer1.getQueQuan());
        System.out.println("Số điện thoại: " + customer1.getSoDienThoai());
        System.out.println("Email: " + customer1.getEmail());

        //Hiển thị thông tin customer2
        System.out.println("Thông tin khách hàng 2:");
        System.out.println("Mã khách hàng: " + customer2.getMaKhachHang());
        System.out.println("Họ tên: " + customer2.getHoTen());
        System.out.println("Giới tính: " + customer2.getGioiTinh());
        System.out.println("Ngày sinh: " + customer2.getNgaySinh().format(dtf));
        System.out.println("Quê quán: " + customer2.getQueQuan());
        System.out.println("Số điện thoại: " + customer2.getSoDienThoai());
        System.out.println("Email: " + customer2.getEmail());
    }
}
