package Session2;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canh1 = sc.nextInt();
        int canh2 = sc.nextInt();
        int canh3 = sc.nextInt();
        if (canh1 <= 0 || canh2 <= 0 || canh3 <= 0) {
            System.out.println("Ba cạnh không tạo thành một tam giác");
            return;
        }
        if(canh1+canh2<=canh3 || canh2+canh3<=canh1||canh1+canh3<=canh2){
            System.out.println("Ba cạnh không tạo thành một tam giác");
        }
        else{
            if(canh1==canh2 && canh1==canh3){
                System.out.println("Đây là tam giác đều");
            } else if (canh1==canh2 || canh1==canh3||canh2==canh3) {
                System.out.println("Đây là tam giác cân");
            }
            else if(canh1*canh1 + canh2*canh2==canh3*canh3||canh1*canh1 + canh3*canh3==canh2*canh2||canh3*canh3 + canh2*canh2==canh1*canh1){
                System.out.println("Đây là tam giác vuông");
            }
            else{
                System.out.println("Đây là tam giác thường");
            }
        }
    }
}
