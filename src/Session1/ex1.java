package Session1;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập bán kính: ");
        double radius = Double.parseDouble(input.nextLine());
        System.out.printf("Diện tích hình tròn: %.2f\n",Math.PI * radius * radius);
    }
}
