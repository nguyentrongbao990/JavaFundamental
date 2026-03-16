package Session6;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] scores = new double[0];

        while (true) {
            System.out.println("\n*************** QUẢN LÝ ĐIỂM SV ***************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n;
                    try {
                        n = Integer.parseInt(input.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Số lượng không hợp lệ.");
                        break;
                    }

                    if (n <= 0) {
                        System.out.println("Số lượng sinh viên phải lớn hơn 0.");
                        break;
                    }

                    scores = new double[n];
                    for (int i = 0; i < n; i++) {
                        while (true) {
                            System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
                            try {
                                double score = Double.parseDouble(input.nextLine().trim());
                                if (score < 0 || score > 10) {
                                    System.out.println("Điểm phải từ 0 đến 10. Nhập lại.");
                                } else {
                                    scores[i] = score;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Điểm không hợp lệ. Nhập lại.");
                            }
                        }
                    }
                    System.out.println("Đã nhập xong danh sách điểm.");
                    break;

                case 2:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    System.out.println("Danh sách điểm sinh viên:");
                    for (int i = 0; i < scores.length; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
                    }
                    break;

                case 3:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    double sum = 0;
                    for (double score : scores) {
                        sum += score;
                    }
                    double average = sum / scores.length;
                    System.out.println("Điểm trung bình: " + average);
                    break;

                case 4:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    double max = scores[0];
                    double min = scores[0];

                    for (int i = 1; i < scores.length; i++) {
                        if (scores[i] > max) {
                            max = scores[i];
                        }
                        if (scores[i] < min) {
                            min = scores[i];
                        }
                    }

                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                case 5:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    int pass = 0;
                    int fail = 0;

                    for (double score : scores) {
                        if (score >= 5) {
                            pass++;
                        } else {
                            fail++;
                        }
                    }

                    System.out.println("Số sinh viên đạt: " + pass);
                    System.out.println("Số sinh viên trượt: " + fail);
                    break;

                case 6:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    bubbleSortAscending(scores);
                    System.out.println("Đã sắp xếp điểm tăng dần.");
                    System.out.println("Danh sách sau khi sắp xếp:");
                    for (int i = 0; i < scores.length; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
                    }
                    break;

                case 7:
                    if (scores.length == 0) {
                        System.out.println("Chưa có dữ liệu điểm.");
                        break;
                    }

                    int gioi = 0;
                    int xuatSac = 0;

                    for (double score : scores) {
                        if (score >= 8 && score < 9) {
                            gioi++;
                        } else if (score >= 9) {
                            xuatSac++;
                        }
                    }

                    System.out.println("Số sinh viên giỏi: " + gioi);
                    System.out.println("Số sinh viên xuất sắc: " + xuatSac);
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    input.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void bubbleSortAscending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}