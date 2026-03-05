package Session3;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int count=0;
        double sum =0;
        double max,min;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("********************* MENU NHẬP ĐIỂM *********************");
            System.out.println("1.      Nhập điểm học viên");
            System.out.println("2.      Hiển thị thống kê");
            System.out.println("3.      Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ (phải là số 1-3).");
                continue; // quay lại in menu
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Lựa chọn không hợp lệ (chỉ 1-3).");
                continue;
            }
            switch (choice){
                case 1:
                    System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    break;
                case 2:
                    System.out.println("--- KẾT QUẢ ---");
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
        while(true);
    }
}
