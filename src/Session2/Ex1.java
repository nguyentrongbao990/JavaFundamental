package Session2;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương N: ");
        int N = input.nextInt();
        if(N<=0) {
            System.out.println("Số nhập vào không hợp lệ");
        }
        else {
            int res=0;
            for (int i = 1; i <=N ; i++) {
                res+=i;
            }
            System.out.println("---Kết quả---");
            System.out.println(res);
        }
    }
}
