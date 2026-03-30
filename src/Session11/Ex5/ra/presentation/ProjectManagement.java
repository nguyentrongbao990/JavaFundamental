package Session11.Ex5.ra.presentation;

import Session11.Ex5.ra.entity.Employee;
import Session11.Ex5.ra.entity.Project;
import Session11.Ex5.ra.entity.ProjectStatus;
import Session11.Ex5.ra.entity.Role;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProjectManagement {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MAX_EMPLOYEE = 100;
    private static final int MAX_PROJECT = 100;

    private static final Employee[] employees = new Employee[MAX_EMPLOYEE];
    private static final Project[] projects = new Project[MAX_PROJECT];

    private static int employeeCount = 0;
    private static int projectCount = 0;

    public static void main(String[] args) {
        do {
            System.out.println("\n================ QUẢN LÝ DỰ ÁN ================");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý dự án");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    employeeMenu();
                    break;
                case "2":
                    projectMenu();
                    break;
                case "3":
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3.");
            }
        } while (true);
    }

    private static void employeeMenu() {
        do {
            System.out.println("\n================ QUẢN LÝ NHÂN VIÊN ================");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addEmployee();
                    break;
                case "2":
                    displayEmployees();
                    break;
                case "3":
                    updateEmployee();
                    break;
                case "4":
                    deleteEmployee();
                    break;
                case "5":
                    searchEmployeeByName();
                    break;
                case "6":
                    sortEmployeesBySalaryDesc();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 7.");
            }
        } while (true);
    }

    private static void projectMenu() {
        do {
            System.out.println("\n================ QUẢN LÝ DỰ ÁN ================");
            System.out.println("1. Thêm dự án");
            System.out.println("2. Hiển thị danh sách dự án");
            System.out.println("3. Cập nhật thông tin dự án");
            System.out.println("4. Xóa dự án (chỉ khi chưa có nhân viên tham gia)");
            System.out.println("5. Thêm nhân viên vào dự án");
            System.out.println("6. Tìm dự án theo tên");
            System.out.println("7. Thống kê số lượng nhân viên theo vai trò trong từng dự án");
            System.out.println("8. Tìm dự án đang chạy và gần kết thúc nhất");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addProject();
                    break;
                case "2":
                    displayProjects();
                    break;
                case "3":
                    updateProject();
                    break;
                case "4":
                    deleteProject();
                    break;
                case "5":
                    addEmployeeToProject();
                    break;
                case "6":
                    searchProjectByName();
                    break;
                case "7":
                    statisticEmployeeByRoleInProject();
                    break;
                case "8":
                    findRunningProjectNearestEndDate();
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 9.");
            }
        } while (true);
    }

    // ======================= QUẢN LÝ NHÂN VIÊN =======================

    private static void addEmployee() {
        if (employeeCount == MAX_EMPLOYEE) {
            System.out.println("Danh sách nhân viên đã đầy.");
            return;
        }

        Employee employee = new Employee();
        employee.inputData(scanner, employees, employeeCount);
        employees[employeeCount++] = employee;
        System.out.println("Thêm nhân viên thành công.");
    }

    private static void displayEmployees() {
        if (employeeCount == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.println("\n--------- DANH SÁCH NHÂN VIÊN ---------");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayData();
        }
    }

    private static void updateEmployee() {
        int index = findEmployeeIndexById(inputEmployeeIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }

        Employee employee = employees[index];

        System.out.print("Nhập tên mới (6-30 ký tự): ");
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.length() >= 6 && name.length() <= 30) {
                employee.setEmployeeName(name);
                break;
            }
            System.out.print("Tên không hợp lệ, nhập lại: ");
        }

        employee.setRole(inputRole());

        System.out.print("Nhập lương mới (> 0): ");
        while (true) {
            try {
                double salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary > 0) {
                    employee.setSalary(salary);
                    break;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Lương không hợp lệ, nhập lại: ");
        }

        System.out.println("Cập nhật nhân viên thành công.");
    }

    private static void deleteEmployee() {
        int index = findEmployeeIndexById(inputEmployeeIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }

        if (isEmployeeInAnyProject(employees[index].getEmployeeId())) {
            System.out.println("Không thể xóa. Nhân viên đang tham gia dự án.");
            return;
        }

        for (int i = index; i < employeeCount - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[employeeCount - 1] = null;
        employeeCount--;

        System.out.println("Xóa nhân viên thành công.");
    }

    private static void searchEmployeeByName() {
        if (employeeCount == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        System.out.print("Nhập tên cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeName().toLowerCase().contains(keyword)) {
                employees[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên phù hợp.");
        }
    }

    private static void sortEmployeesBySalaryDesc() {
        if (employeeCount == 0) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        for (int i = 0; i < employeeCount - 1; i++) {
            for (int j = 0; j < employeeCount - i - 1; j++) {
                if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }

        System.out.println("Đã sắp xếp nhân viên theo lương giảm dần.");
        displayEmployees();
    }

    // ======================= QUẢN LÝ DỰ ÁN =======================

    private static void addProject() {
        if (projectCount == MAX_PROJECT) {
            System.out.println("Danh sách dự án đã đầy.");
            return;
        }

        Project project = new Project();
        project.inputData(scanner, projects, projectCount, employees, employeeCount);
        projects[projectCount++] = project;
        System.out.println("Thêm dự án thành công.");
    }

    private static void displayProjects() {
        if (projectCount == 0) {
            System.out.println("Danh sách dự án trống.");
            return;
        }

        System.out.println("\n--------- DANH SÁCH DỰ ÁN ---------");
        for (int i = 0; i < projectCount; i++) {
            projects[i].displayData();
        }
    }

    private static void updateProject() {
        int index = findProjectIndexById(inputProjectIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy dự án.");
            return;
        }

        Project project = projects[index];

        String projectName;
        while (true) {
            System.out.print("Nhập tên dự án mới (10-50 ký tự, duy nhất): ");
            projectName = scanner.nextLine().trim();
            if (projectName.length() < 10 || projectName.length() > 50) {
                System.out.println("Tên dự án không hợp lệ.");
                continue;
            }
            if (isDuplicateProjectName(projectName, index)) {
                System.out.println("Tên dự án đã tồn tại.");
                continue;
            }
            break;
        }
        project.setProjectName(projectName);

        LocalDate startDate = inputDate("Nhập ngày bắt đầu mới (yyyy-MM-dd): ");
        LocalDate endDate;
        while (true) {
            endDate = inputDate("Nhập ngày kết thúc mới (yyyy-MM-dd): ");
            if (!endDate.isBefore(startDate)) {
                break;
            }
            System.out.println("Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu.");
        }

        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setStatus(inputProjectStatus());

        System.out.println("Cập nhật dự án thành công.");
    }

    private static void deleteProject() {
        int index = findProjectIndexById(inputProjectIdToFind());
        if (index == -1) {
            System.out.println("Không tìm thấy dự án.");
            return;
        }

        if (projects[index].getEmployees() != null && projects[index].getEmployees().length > 0) {
            System.out.println("Không thể xóa dự án vì đã có nhân viên tham gia.");
            return;
        }

        for (int i = index; i < projectCount - 1; i++) {
            projects[i] = projects[i + 1];
        }
        projects[projectCount - 1] = null;
        projectCount--;

        System.out.println("Xóa dự án thành công.");
    }

    private static void addEmployeeToProject() {
        int projectIndex = findProjectIndexById(inputProjectIdToFind());
        if (projectIndex == -1) {
            System.out.println("Không tìm thấy dự án.");
            return;
        }

        int employeeIndex = findEmployeeIndexById(inputEmployeeIdToFind());
        if (employeeIndex == -1) {
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }

        Project project = projects[projectIndex];
        Employee employee = employees[employeeIndex];

        Employee[] currentEmployees = project.getEmployees();
        if (currentEmployees == null) {
            currentEmployees = new Employee[0];
        }

        for (Employee emp : currentEmployees) {
            if (emp.getEmployeeId().equalsIgnoreCase(employee.getEmployeeId())) {
                System.out.println("Nhân viên đã có trong dự án.");
                return;
            }
        }

        Employee[] newEmployees = new Employee[currentEmployees.length + 1];
        for (int i = 0; i < currentEmployees.length; i++) {
            newEmployees[i] = currentEmployees[i];
        }
        newEmployees[currentEmployees.length] = employee;
        project.setEmployees(newEmployees);

        System.out.println("Thêm nhân viên vào dự án thành công.");
    }

    private static void searchProjectByName() {
        if (projectCount == 0) {
            System.out.println("Danh sách dự án trống.");
            return;
        }

        System.out.print("Nhập tên dự án cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < projectCount; i++) {
            if (projects[i].getProjectName().toLowerCase().contains(keyword)) {
                projects[i].displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy dự án phù hợp.");
        }
    }

    private static void statisticEmployeeByRoleInProject() {
        if (projectCount == 0) {
            System.out.println("Danh sách dự án trống.");
            return;
        }

        for (int i = 0; i < projectCount; i++) {
            Project project = projects[i];
            int dev = 0, tester = 0, pm = 0, ba = 0;

            Employee[] empArr = project.getEmployees();
            if (empArr != null) {
                for (Employee emp : empArr) {
                    switch (emp.getRole()) {
                        case DEV:
                            dev++;
                            break;
                        case TESTER:
                            tester++;
                            break;
                        case PM:
                            pm++;
                            break;
                        case BA:
                            ba++;
                            break;
                    }
                }
            }

            System.out.println("Dự án: " + project.getProjectName());
            System.out.println("DEV: " + dev);
            System.out.println("TESTER: " + tester);
            System.out.println("PM: " + pm);
            System.out.println("BA: " + ba);
            System.out.println("------------------------------------");
        }
    }

    private static void findRunningProjectNearestEndDate() {
        if (projectCount == 0) {
            System.out.println("Danh sách dự án trống.");
            return;
        }

        Project nearestProject = null;

        for (int i = 0; i < projectCount; i++) {
            if (projects[i].getStatus() == ProjectStatus.RUNNING) {
                if (nearestProject == null ||
                        projects[i].getEndDate().isBefore(nearestProject.getEndDate())) {
                    nearestProject = projects[i];
                }
            }
        }

        if (nearestProject == null) {
            System.out.println("Không có dự án nào đang ở trạng thái RUNNING.");
        } else {
            System.out.println("Dự án đang chạy và gần kết thúc nhất:");
            nearestProject.displayData();
        }
    }

    // ======================= HÀM HỖ TRỢ =======================

    private static int findEmployeeIndexById(String employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    private static int findProjectIndexById(String projectId) {
        for (int i = 0; i < projectCount; i++) {
            if (projects[i].getProjectId().equalsIgnoreCase(projectId)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isDuplicateProjectName(String projectName, int currentIndex) {
        for (int i = 0; i < projectCount; i++) {
            if (i != currentIndex &&
                    projects[i].getProjectName().equalsIgnoreCase(projectName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmployeeInAnyProject(String employeeId) {
        for (int i = 0; i < projectCount; i++) {
            Employee[] empArr = projects[i].getEmployees();
            if (empArr != null) {
                for (Employee emp : empArr) {
                    if (emp.getEmployeeId().equalsIgnoreCase(employeeId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String inputEmployeeIdToFind() {
        System.out.print("Nhập mã nhân viên: ");
        return scanner.nextLine().trim();
    }

    private static String inputProjectIdToFind() {
        System.out.print("Nhập mã dự án: ");
        return scanner.nextLine().trim();
    }

    private static Role inputRole() {
        while (true) {
            System.out.println("Chọn vai trò:");
            System.out.println("1. DEV");
            System.out.println("2. TESTER");
            System.out.println("3. PM");
            System.out.println("4. BA");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    return Role.DEV;
                case "2":
                    return Role.TESTER;
                case "3":
                    return Role.PM;
                case "4":
                    return Role.BA;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static ProjectStatus inputProjectStatus() {
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

    private static LocalDate inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ, đúng định dạng yyyy-MM-dd.");
            }
        }
    }
}
