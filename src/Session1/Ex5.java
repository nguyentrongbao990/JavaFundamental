package Session1;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập cân nặng (kg):  ");
        double weight = Double.parseDouble(input.nextLine());
        if(weight <=0){
            System.out.println("Cân nặng phải lớn hơn 0");
            return;
        }
        System.out.println("Nhập chiều cao (m): ");
        double height = Double.parseDouble(input.nextLine());
        if(height <=0){
            System.out.println("Chiều cao phải lớn hơn 0");
            return;
        }
        double bmi= weight/(height*height);
        System.out.printf("Chỉ số BMI= %.2f%n",bmi);
    }
}
