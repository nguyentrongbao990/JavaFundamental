package Session3;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int count=0;
        double sum =0;
        double max=0,min=0;
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
                    while(true){
                        System.out.print("Nhập điểm: ");
                        String temp = sc.nextLine();
                        double score;
                        try{
                            score = Double.parseDouble(temp);
                        }
                        catch(NumberFormatException e){
                            System.out.println("Nhập điểm: Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }
                        if(score==-1) break;
                        if(score<0 ||score >10){
                            System.out.println("Nhập điểm: Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }
                        if(count==0) min=max=score;
                        else{
                            if(max<score) max=score;
                            if(min>score) min=score;
                        }
                        sum+=score;
                        count++;
                        if(score>=0 && score<5){
                            System.out.println("Học lực: Yếu");
                        }
                        else if(score>=5 && score<7){
                            System.out.println("Học lực: Trung bình");
                        }
                        else if(score>=7 && score<8){
                            System.out.println("Học lực: Khá");
                        }
                        else if(score>=8 && score<9){
                            System.out.println("Học lực: Giỏi");
                        }
                        else {
                            System.out.println("Học lực: Xuất sắc");
                        }
                    }
                    break;
                case 2:
                    System.out.println("--- KẾT QUẢ ---");
                    if(count==0){
                        System.out.println("Chưa có dữ liệu");
                    }
                    else {
                        System.out.println("Số học viên đã nhập: "+count);
                        System.out.printf("Điểm trung bình: %.2f\n",sum/(double)count);
                        System.out.printf("Điểm cao nhất: %.2f\n",max);
                        System.out.printf("Điểm thấp nhất: %.2f\n",min);
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }
        }
        while(true);
    }
}
