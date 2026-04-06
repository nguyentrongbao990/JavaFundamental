package Session15.Ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubjectManager<Subject> manager = new SubjectManager<>();

        // Dữ liệu mẫu
        manager.addSubject(new Subject("SUB01", "Java Core", 4, LocalDate.of(2025, 5, 10)));
        manager.addSubject(new Subject("SUB02", "Database", 3, LocalDate.of(2025, 6, 15)));
        manager.addSubject(new Subject("SUB03", "Web Java", 5, LocalDate.of(2025, 7, 20)));

        int choice;

        do {
            showMenu();

            try {
                System.out.print("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manager.displayAllSubjects();
                        break;
                    case 2:
                        addSubject(scanner, manager);
                        break;
                    case 3:
                        removeSubject(scanner, manager);
                        break;
                    case 4:
                        searchSubjectByName(scanner, manager);
                        break;
                    case 5:
                        filterSubjectsByCredits(manager);
                        break;
                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                choice = -1;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n========= MENU =========");
        System.out.println("1. Hiển thị danh sách môn học");
        System.out.println("2. Thêm môn học");
        System.out.println("3. Xóa môn học");
        System.out.println("4. Tìm kiếm môn học theo tên");
        System.out.println("5. Lọc môn học theo tín chỉ");
        System.out.println("0. Thoát");
        System.out.println("========================");
    }

    public static void addSubject(Scanner scanner, SubjectManager<Subject> manager) {
        try {
            System.out.print("Nhập code: ");
            String code = scanner.nextLine();

            System.out.print("Nhập name: ");
            String name = scanner.nextLine();

            System.out.print("Nhập credits: ");
            int credits = Integer.parseInt(scanner.nextLine());

            validateCredits(credits);

            System.out.print("Nhập startDate (yyyy-MM-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine(), FORMATTER);

            Subject subject = new Subject(code, name, credits, startDate);
            manager.addSubject(subject);

            System.out.println("Thêm môn học thành công.");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Credits phải là số nguyên!");
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi: Ngày phải đúng định dạng yyyy-MM-dd!");
        }
    }

    public static void removeSubject(Scanner scanner, SubjectManager<Subject> manager) {
        System.out.print("Nhập code môn học cần xóa: ");
        String code = scanner.nextLine();

        manager.removeSubjectByCode(code);
        System.out.println("Xóa môn học thành công.");
    }

    public static void searchSubjectByName(Scanner scanner, SubjectManager<Subject> manager) {
        System.out.print("Nhập tên môn học cần tìm: ");
        String keyword = scanner.nextLine();

        Optional<Subject> result = manager.searchByName(keyword);

        if (result.isPresent()) {
            System.out.println("Môn học tìm thấy:");
            System.out.println(result.get());
        } else {
            System.out.println("Không có môn học phù hợp.");
        }
    }

    public static void filterSubjectsByCredits(SubjectManager<Subject> manager) {
        List<Subject> filteredList = manager.filterByCreditsGreaterThan(3);

        if (filteredList.isEmpty()) {
            System.out.println("Không có môn học nào có số tín chỉ > 3.");
            return;
        }

        System.out.println("Các môn học có số tín chỉ > 3:");
        filteredList.forEach(System.out::println);
    }

    public static void validateCredits(int credits) {
        if (credits < 0 || credits > 10) {
            throw new IllegalArgumentException("Số tín chỉ không hợp lệ! Credits phải từ 0 đến 10.");
        }
    }
}