package Session1;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tử số phân số thứ nhất: ");
        int a = Integer.parseInt(input.nextLine());
        System.out.println("Nhập mẫu số phân số thứ nhất: ");
        int b = Integer.parseInt(input.nextLine());
        System.out.println("Nhập tử số phân số thứ hai: ");
        int c = Integer.parseInt(input.nextLine());
        System.out.println("Nhập mẫu số phân số thứ hai: ");
        int d = Integer.parseInt(input.nextLine());
        System.out.println("---Kết quả---");
        System.out.println((a*d+b*c)+"/"+(b*d));
    }
}
