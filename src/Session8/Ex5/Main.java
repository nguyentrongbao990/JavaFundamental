package Session8.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        do{
            System.out.println("===== MENU SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String line = input.nextLine();
            int choice;
            try{
                choice = Integer.parseInt(line);
            }
            catch(NumberFormatException e){
                System.out.println("Lựa chọn không hợp lệ (phải là số 0-4).");
                continue;
            }
            switch(choice){
                case 1:
                    students.clear();
                    System.out.println("Số lượng sinh viên muốn nhập: ");
                    int n = Integer.parseInt(input.nextLine());
                    System.out.println("Nhập thông tin cho từng sinh viên:");
                    for (int i = 0; i < n; i++) {
                        Student student = new Student();
                        student.input(input);
                        students.add(student);
                    }
                    break;
                case 2:
                    if(students.size()>0){
                        for (int i = 0; i < students.size(); i++) {
                            System.out.printf("Sinh viên %d:\n",i+1);
                            students.get(i).print();
                        }
                    }
                    else{
                        System.out.println("Danh sách sinh viên rỗng");
                    }
                    break;
                case 3:
                    if(students.isEmpty()){
                        System.out.println("Danh sách sinh viên rỗng");
                    }
                    else{
                        Student bestStudent = students.get(0);
                        for (int i = 1; i < students.size(); i++) {
                            if(bestStudent.getGpa() < students.get(i).getGpa()){
                                bestStudent = students.get(i);
                            }
                        }
                        System.out.println("Thông tin sinh viên có gpa cao nhất:");
                        bestStudent.print();
                    }
                    break;
                case 4:
                    System.out.println("Tổng số sinh viên đã tạo: "+Student.getTotalStudent());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn phải là số từ 0 - 4");
                    break;
            }
        }
        while(true);

    }
}
