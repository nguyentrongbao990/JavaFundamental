package Session2;

import java.util.Scanner;

public class Ex5 {
    //Phương thức map chữ -> số
    static String digitWord(int d){
        return switch (d){
            case 0 -> "không";
            case 1 -> "một";
            case 2 -> "hai";
            case 3 -> "ba";
            case 4 -> "bốn";
            case 5 -> "năm";
            case 6 -> "sáu";
            case 7 -> "bảy";
            case 8 -> "tám";
            case 9 -> "chín";
            default -> "";
        };
    }
    // Viết hoa chữ cái đầu
    static String captilize(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    };
    // xử lý trường hợp đặc biệt cho hàng đơn vị
    static String unitWord(int tens, int units){
        if(units==0) return "";
        if(tens>=2&&units ==1) return "mốt";
        if(tens>=1 && units ==5) return "lăm";
        return digitWord(units);
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<100||n>=1000){
            System.out.println("Số nhập vào không hợp lệ");
            return;
        }
        int hundreds = n/100; //hàng trăm
        int tens = (n/10)%10; //hàng chục
        int units = n%10; //hàng đơn vị
        StringBuilder sb = new StringBuilder(); //sử dụng StringBuilder để nối chuỗi
        sb.append(captilize(digitWord(hundreds))).append(" trăm"); //Nối hàng trăm
        //nối hàng chục và đơn vị
        if(tens==0){
            if(units!=0){
            sb.append(" lẻ ").append(unitWord(tens,units));}
        } else if (tens==1) {
            sb.append(" mười");
            if(units!=0) sb.append(" ").append(unitWord(tens,units));
        }
        else{
            sb.append(" ").append(digitWord(tens)).append(" mươi");
            if(units!=0) sb.append(" ").append(unitWord(tens,units));
        }
        //in kết quả
        System.out.println(sb.toString().trim());
    }
}
