package Session13.Ex5;

public class Student {
    private static int AUTO_ID = 1;

    private int id;
    private String name;
    private double gpa;

    public Student() {
        this.id = AUTO_ID++;
    }

    public Student(String name, double gpa) {
        this.id = AUTO_ID++;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 10) {
            this.gpa = gpa;
        }
    }

    public String getRank() {
        if (gpa >= 8.5) {
            return "Xuất sắc";
        } else if (gpa >= 7.0) {
            return "Giỏi";
        } else if (gpa >= 5.5) {
            return "Khá";
        } else {
            return "Trung bình / Yếu";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Họ tên: " + name +
                " | GPA: " + String.format("%.2f", gpa) +
                " | Xếp loại: " + getRank();
    }
}