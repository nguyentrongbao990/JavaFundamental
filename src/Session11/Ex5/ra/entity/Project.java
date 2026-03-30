package Session11.Ex5.ra.entity;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees;
    private ProjectStatus status;

    public Project() {
        this.employees = new Employee[0];
    }

    public Project(String projectId, String projectName, LocalDate startDate,
                   LocalDate endDate, Employee[] employees, ProjectStatus status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = employees;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Project[] arrProject, int index, Employee[] arrEmp, int empIndex) {
        this.projectId = inputProjectId(scanner, arrProject, index);
        this.projectName = inputProjectName(scanner, arrProject, index);
        this.startDate = inputDate(scanner, "Nhập ngày bắt đầu (yyyy-MM-dd): ");
        this.endDate = inputEndDate(scanner, this.startDate);
        this.employees = inputEmployees(scanner, arrEmp, empIndex);
        this.status = inputStatus(scanner);
    }

    private String inputProjectId(Scanner scanner, Project[] arrProject, int index) {
        while (true) {
            System.out.print("Nhập mã dự án (P + 4 số, ví dụ P0001): ");
            String id = scanner.nextLine().trim();
            if (!id.matches("^P\\d{4}$")) {
                System.out.println("Mã dự án không đúng định dạng.");
                continue;
            }
            boolean existed = false;
            for (int i = 0; i < index; i++) {
                if (arrProject[i] != null && arrProject[i].getProjectId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println("Mã dự án đã tồn tại.");
            } else {
                return id;
            }
        }
    }

    private String inputProjectName(Scanner scanner, Project[] arrProject, int index) {
        while (true) {
            System.out.print("Nhập tên dự án (10-50 ký tự, duy nhất): ");
            String name = scanner.nextLine().trim();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên dự án phải từ 10 đến 50 ký tự.");
                continue;
            }
            boolean existed = false;
            for (int i = 0; i < index; i++) {
                if (arrProject[i] != null &&
                        arrProject[i].getProjectName().equalsIgnoreCase(name)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println("Tên dự án đã tồn tại.");
            } else {
                return name;
            }
        }
    }

    private LocalDate inputDate(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, đúng định dạng yyyy-MM-dd.");
            }
        }
    }

    private LocalDate inputEndDate(Scanner scanner, LocalDate startDate) {
        while (true) {
            LocalDate endDate = inputDate(scanner, "Nhập ngày kết thúc (yyyy-MM-dd): ");
            if (!endDate.isBefore(startDate)) {
                return endDate;
            }
            System.out.println("Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu.");
        }
    }

    private Employee[] inputEmployees(Scanner scanner, Employee[] arrEmp, int empIndex) {
        if (empIndex == 0) {
            System.out.println("Chưa có nhân viên nào để gán vào dự án.");
            return new Employee[0];
        }

        int number;
        while (true) {
            try {
                System.out.printf("Nhập số lượng nhân viên tham gia (0 - %d): ", empIndex);
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= 0 && number <= empIndex) {
                    break;
                }
                System.out.println("Số lượng không hợp lệ.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }

        Employee[] selected = new Employee[number];
        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.printf("Nhập mã nhân viên thứ %d: ", i + 1);
                String empId = scanner.nextLine().trim();

                Employee found = null;
                for (int j = 0; j < empIndex; j++) {
                    if (arrEmp[j] != null && arrEmp[j].getEmployeeId().equalsIgnoreCase(empId)) {
                        found = arrEmp[j];
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("Không tìm thấy nhân viên.");
                    continue;
                }

                boolean duplicate = false;
                for (int j = 0; j < i; j++) {
                    if (selected[j].getEmployeeId().equalsIgnoreCase(empId)) {
                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    System.out.println("Nhân viên đã được thêm trước đó.");
                } else {
                    selected[i] = found;
                    break;
                }
            }
        }
        return selected;
    }

    private ProjectStatus inputStatus(Scanner scanner) {
        while (true) {
            System.out.println("Chọn trạng thái dự án:");
            System.out.println("1. PLANNING");
            System.out.println("2. RUNNING");
            System.out.println("3. FINISHED");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    return ProjectStatus.PLANNING;
                case "2":
                    return ProjectStatus.RUNNING;
                case "3":
                    return ProjectStatus.FINISHED;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void displayData() {
        System.out.println("--------------------------------------------------");
        System.out.println("Mã dự án: " + projectId);
        System.out.println("Tên dự án: " + projectName);
        System.out.println("Ngày bắt đầu: " + startDate);
        System.out.println("Ngày kết thúc: " + endDate);
        System.out.println("Trạng thái: " + status);
        System.out.println("Danh sách nhân viên tham gia:");

        if (employees == null || employees.length == 0) {
            System.out.println("Không có nhân viên tham gia.");
        } else {
            for (Employee employee : employees) {
                System.out.printf("- %s | %s | %s%n",
                        employee.getEmployeeId(),
                        employee.getEmployeeName(),
                        employee.getRole());
            }
        }
    }
}