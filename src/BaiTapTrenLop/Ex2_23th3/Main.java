package BaiTapTrenLop.Ex2_23th3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WashingMachine wm = new WashingMachine();
        AirConditioner ac = new AirConditioner();

        System.out.println("Nhập thông tin máy giặt:");
        wm.input(sc);

        System.out.println();
        System.out.println("Nhập thông tin điều hòa:");
        ac.input(sc);

        System.out.println();
        wm.display();

        System.out.println();
        ac.display();

        sc.close();
    }
}
