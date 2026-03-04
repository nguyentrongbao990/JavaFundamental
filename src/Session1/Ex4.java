package Session1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chiều rộng: ");
        float weight = input.nextFloat();
        System.out.println("Nhập chiều cao: ");
        float height = input.nextFloat();
        float area = weight*height;
        float perimeter = 2*(weight+height);
        System.out.printf("Diện tích: %.2f\n",area);
        System.out.printf("Chu vi: %.2f\n",perimeter);
    }
}
