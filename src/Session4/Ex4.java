package Session4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.println("Nhập số lượng phần tử: ");
            n=sc.nextInt();
            if(n==0){
                System.out.println("Mảng không có phần tử");
            }
            else if(n<0) System.out.println("Số lượng phần tử không hợp lệ (phải >0). Nhập lại");
            else break;
        }while(true);
        int []arr = new int[n];
        System.out.println("Nhập các phần tử của mảng");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int []result = new int[n];
        int count=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]%2==0){
                result[count++]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]%2==1){
                result[count++]=arr[i];
            }
        }
        System.out.println("Mảng sau khi sắp xếp:");
        for(int x: result){
            System.out.print(x+" ");
        }
    }
}
