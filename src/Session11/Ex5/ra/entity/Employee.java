package Session11.Ex5.ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Role role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {
        this.employeeId = inputEmployeeId(scanner, arrEmp, index);
        this.employeeName = inputEmployeeName(scanner);
        this.role = inputRole(scanner);
        this.salary = inputSalary(scanner);
    }

    private String inputEmployeeId(Scanner scanner, Employee[] arrEmp, int index) {
        while (true) {
            System.out.print("Nhập mã nhân viên (E + 4 số, ví dụ E0001): ");
            String id = scanner.nextLine().trim();
            if (!id.matches("^E\\d{4}$")) {
                System.out.println("Mã nhân viên không đúng định dạng.");
                continue;
            }
            boolean existed = false;
            for (int i = 0; i < index; i++) {
                if (arrEmp[i] != null && arrEmp[i].getEmployeeId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println("Mã nhân viên đã tồn tại.");
            } else {
                return id;
            }
        }
    }

    private String inputEmployeeName(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên nhân viên (6-30 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() >= 6 && name.length() <= 30) {
                return name;
            }
            System.out.println("Tên nhân viên phải từ 6 đến 30 ký tự.");
        }
    }

    private Role inputRole(Scanner scanner) {
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

    private double inputSalary(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập lương (> 0): ");
                double salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary > 0) {
                    return salary;
                }
                System.out.println("Lương phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public void displayData() {
        System.out.printf("Mã NV: %s | Tên NV: %s | Vai trò: %s | Lương: %.2f%n",
                employeeId, employeeName, role, salary);
    }
}
