package Session11.Ex3;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee(1, "Nguyen Van A", 12000000);
        employees[1] = new PartTimeEmployee(2, "Tran Thi B", 80, 50000);
        employees[2] = new FullTimeEmployee(3, "Le Van C", 15000000);

        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("Lương: " + employee.calculateSalary());

            if (employee instanceof BonusEligible) {
                BonusEligible bonusEmployee = (BonusEligible) employee;
                System.out.println("Thưởng: " + bonusEmployee.calculateBonus());
            }

            System.out.println("---------------------------");
        }
    }
}