package Session1;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập vận tốc (km/h): ");
        double vanToc= Double.parseDouble(input.nextLine());
        if(vanToc<0){
            System.out.println("Vận tốc phải lớn hơn 0");
            return;
        }
        System.out.println("Nhập thời gian đi (h): ");
        double thoiGian= Double.parseDouble(input.nextLine());
        if(thoiGian<0){
            System.out.println("Thời gian phải >0");
            return;
        }
        double quangDuong = vanToc*thoiGian;
        System.out.printf("Quãng đường =%.2f%n",quangDuong);
    }
}
