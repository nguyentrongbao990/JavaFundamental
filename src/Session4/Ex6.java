package Session4;

import java.util.Scanner;

public class Ex6 {
    public static final double EPS = 1e-9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n <= 0) {
            System.out.println("Số lượng nhân viên phải lớn hơn 0.");
            return;
        }

        double[] salaries = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập lương nhân viên " + (i + 1) + ": ");
            salaries[i] = Double.parseDouble(sc.nextLine());
        }

        boolean isSortedAsc = false;

        while (true) {
            System.out.println("\n--- QUẢN LÝ LƯƠNG NHÂN VIÊN ---");
            System.out.println("1. Xem danh sách lương");
            System.out.println("2. Sắp xếp lương");
            System.out.println("3. Tìm kiếm lương");
            System.out.println("4. Thống kê lương");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    showSalaries(salaries);
                    break;

                case 2:
                    System.out.println("Chọn cách sắp xếp:");
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    System.out.print("Lựa chọn của bạn: ");

                    int sortChoice;
                    try {
                        sortChoice = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                    }

                    if (sortChoice == 1) {
                        bubbleSortAscending(salaries);
                        isSortedAsc = true;
                        System.out.println("Đã sắp xếp lương tăng dần.");
                        showSalaries(salaries);
                    } else if (sortChoice == 2) {
                        bubbleSortDescending(salaries);
                        isSortedAsc = false;
                        System.out.println("Đã sắp xếp lương giảm dần.");
                        showSalaries(salaries);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập lương cần tìm: ");
                    double target;
                    try {
                        target = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lương nhập không hợp lệ.");
                        break;
                    }

                    int linearPos = linearSearch(salaries, target);
                    if (linearPos == -1) {
                        System.out.println("Linear Search: Không tìm thấy");
                    } else {
                        System.out.println("Linear Search: Tìm thấy tại vị trí " + linearPos);
                    }

                    if (isSortedAsc) {
                        int binaryPos = binarySearchAscending(salaries, target);
                        if (binaryPos == -1) {
                            System.out.println("Binary Search (mảng tăng dần): Không tìm thấy");
                        } else {
                            System.out.println("Binary Search (mảng tăng dần): Tìm thấy tại vị trí " + binaryPos);
                        }
                    } else {
                        System.out.println("Binary Search chỉ áp dụng khi mảng đã sắp xếp tăng dần.");
                    }
                    break;

                case 4:
                    statistics(salaries);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 5.");
            }
        }
    }

    public static void showSalaries(double[] salaries) {
        System.out.println("Danh sách lương nhân viên:");
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Nhân viên " + (i + 1) + ": " + salaries[i]);
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

    public static void bubbleSortDescending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
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

    public static int linearSearch(double[] arr, double target) {
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - target) < EPS) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchAscending(double[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (Math.abs(arr[mid] - target) < EPS) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void statistics(double[] arr) {
        double sum = 0;
        double max = arr[0];
        double min = arr[0];

        for (double salary : arr) {
            sum += salary;

            if (salary > max) {
                max = salary;
            }

            if (salary < min) {
                min = salary;
            }
        }

        double avg = sum / arr.length;

        int countAboveAvg = 0;
        for (double salary : arr) {
            if (salary > avg) {
                countAboveAvg++;
            }
        }

        System.out.println("Tổng lương: " + sum);
        System.out.println("Lương trung bình: " + avg);
        System.out.println("Lương cao nhất: " + max);
        System.out.println("Lương thấp nhất: " + min);
        System.out.println("Số nhân viên có lương trên trung bình: " + countAboveAvg);
    }
}
