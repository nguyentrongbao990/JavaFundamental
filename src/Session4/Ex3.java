package Session4;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        System.out.println("Nhập các phần tử của mảng: ");
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Phần tử thứ %d: ", i + 1);
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for(int x: arr){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Nhập số cần tìm: ");
        int searchValue = sc.nextInt();
        boolean founded = false;
        for (int i = 0; i < n; i++) {
            if(arr[i] == searchValue){
                System.out.printf("Tìm kiếm tuyến tính: Số %d có tại vị trí %d\n",searchValue,i);
                founded = true;
                break;
            }
        }
        if(!founded){
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy số cần tìm");
        }
        int bs=binarySearch(arr,searchValue);
        if(bs==-1){
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy số cần tìm");
        }
        else{
            System.out.printf("Tìm kiếm nhị phân: Số %d có tại vị trí %d\n",searchValue,bs);
        }

    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex =i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
    public static int binarySearch(int[] arr, int searchValue){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == searchValue){
                return mid;
            }
            else if(arr[mid] < searchValue){
                high = mid - 1;
            }
            else if(arr[mid] > searchValue){
                low = mid + 1;
            }
        }
        return -1;
    }
}

