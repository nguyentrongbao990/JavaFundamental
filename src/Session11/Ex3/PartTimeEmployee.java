package Session11.Ex3;

public class PartTimeEmployee extends Employee {
    private double workingHour;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double workingHour, double hourlyRate) {
        super(id, name);
        this.workingHour = workingHour;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHour * hourlyRate;
    }
}