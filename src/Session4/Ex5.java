package Session4;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());
        double []arr = new double[n];
        double sum=0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập điểm sinh viên thứ %d: ",i+1);
            arr[i] = Double.parseDouble(sc.nextLine());
            sum+=arr[i];
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        boolean isSortINC = false;
        boolean isSortDEC = false;
        do {
            System.out.println("--- QUẢN LÝ ĐIỂM SINH VIÊN ---");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String line = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line);
            }catch (NumberFormatException e){
                System.out.println("Lựa chọn không hợp lệ (phải là số từ 1-5). Nhập lại");
                continue;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Lựa chọn không hợp lệ (chỉ từ 1-5). Nhập lại");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Danh sách điểm:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Sinh viên %d: %.1f\n",i+1,arr[i]);
                    }
                    break;
                case 2:
                    do{
                        System.out.println("Chọn cách sắp xếp:");
                        System.out.println("1. Tăng dần");
                        System.out.println("2. Giảm dần");
                        String temp = sc.nextLine();
                        int sortChoice;
                        try{
                            sortChoice = Integer.parseInt(temp);
                        }
                        catch (NumberFormatException e){
                            System.out.println("Lựa chọn phải là số (1-2)");
                            continue;
                        }
                        if (sortChoice < 1 || sortChoice > 2) {
                            System.out.println("Lựa chọn phải từ 1-2");
                            continue;
                        }
                        switch (sortChoice) {
                            case 1:
                                bubbleSortINC(arr);
                                System.out.println("Đã sắp xếp tăng dần.");
                                isSortINC = true;
                                break;
                            case 2:
                                bubbleSortDEC(arr);
                                System.out.println("Đã sắp xếp giảm dần.");
                                isSortDEC = true;
                                break;
                        }
                        break;
                    }while(true);
                    break;
                case 3:
                    System.out.print("Nhập điểm cần tìm: ");
                    double score = Double.parseDouble(sc.nextLine());
                    int found = linearSearch(arr, score);
                    if(found == -1){
                        System.out.println("Không tìm thấy điểm");
                    }
                    else {
                        System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí "+found);
                        if(isSortINC){
                            System.out.println("Tìm kiếm nhị phân (mảng tăng dần): Tìm thấy tại vị trí "+binarySearchINC(arr,score));
                        }
                        else if(isSortDEC){
                            System.out.println("Tìm kiếm nhị phân (mảng giảm dần): Tìm thấy tại vị trí "+binarySearchDEC(arr,score));
                        }
                        else System.out.println("Tìm kiếm nhị phân: Danh sách chưa được sắp xếp");
                    }
                    break;
                case 4:
                    System.out.printf("Điểm trung bình: %.1f\n",sum/n);
                    System.out.printf("Điểm cao nhất: %.1f\n",max);
                    System.out.printf("Điểm thấp nhất: %.1f\n",min);
                    int count =0;
                    for(int i=0;i<n;i++){
                        if(arr[i]>sum/n) count++;
                    }
                    System.out.println("Số sinh viên có điểm trên trung bình: "+count);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

            }
        }while(true);
    }
    public static void bubbleSortINC(double[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
    public static void bubbleSortDEC(double[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
    public static int linearSearch(double[] arr, double value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearchINC(double[] arr, double value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value){
                return mid;
            }
            if (arr[mid] > value){
                high = mid - 1;
            }
            if (arr[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }
    public static int binarySearchDEC(double[] arr, double value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value){
                return mid;
            }
            if (arr[mid] > value){
                low = mid + 1;
            }
            if (arr[mid] < value){
                high = mid - 1;
            }
        }
        return -1;
    }
}
