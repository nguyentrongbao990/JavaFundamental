package Session5;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email = input.nextLine().trim();
        String regex ="^[\\w\\.]+@([A-Za-z0-9]+\\.)+[a-zA-Z]{2,6}$";
        if(email.matches(regex)){
            System.out.println("Email hợp lệ!");
        }
        else{
            System.out.println("Email không hợp lệ!");
        }
    }
}
