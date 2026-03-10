package Session4;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng:");
        int n =  Integer.parseInt(input.nextLine());
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for(int i = 0; i < n; i++){
            System.out.printf("Phần tử thứ %d: ",i+1);
            arr[i] = Integer.parseInt(input.nextLine());
        }
        bubbleSort(arr);
        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean swap = true;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = false;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
