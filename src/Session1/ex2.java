package Session1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất (FirstNumber): ");
        int firstNumber = Integer.parseInt(scan.nextLine());
        System.out.println("Nhập số thứ hai (SecondNumber): ");
        int secondNumber = Integer.parseInt(scan.nextLine());
        System.out.println("--- Kết quả ---");
        System.out.println("First number= " + firstNumber);
        System.out.println("Second number= " + secondNumber);
        System.out.println("Tổng= "+(firstNumber+secondNumber));
        System.out.println("Hiệu= "+(firstNumber-secondNumber));
        System.out.println("Tích= "+ (firstNumber*secondNumber));
        System.out.printf("Thương =%.2f\n",(double)firstNumber/secondNumber);
        System.out.println("Phần dư ="+firstNumber%secondNumber);
    }
}
