package Session2;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số nguyên n");
        int n = input.nextInt();
        int res=0;
        if(n<0){
            n*=-1;
        }
        while(n>0){
            int temp=n%10;
            n=n/10;
            res=res+temp;
        }
        System.out.println("Tổng các chữ số là: "+res);
    }
}
