package Session4;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int col = sc.nextInt();
        int [][]arr = new int[row][col];
        System.out.println("Nhập các phần tử của mảng:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.printf("Phần tử [%d][%d]: ",i,j);
                arr[i][j] = sc.nextInt();
            }
        }
        long evenSum = 0;
        long oddSum = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]%2==0){
                    evenSum+=arr[i][j];
                }
                else if(arr[i][j]%2==1){
                    oddSum+=arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: "+ evenSum);
        System.out.println("Tổng các số lẻ: "+ oddSum);
    }

}
