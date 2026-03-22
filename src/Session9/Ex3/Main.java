package Session9.Ex3;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Nguyen Van A", 20, 3.5);
        Student s2 = new Student(2, "Tran Thi B", 19, 3.8);
        Student s3 = new Student(3, "Le Van C", 21, 3.2);

        Student[] students = {s1, s2, s3};

        System.out.println("----- LIST OF STUDENTS -----");
        for (int i = 0; i < students.length; i++) {
            students[i].printInfo();
        }

        System.out.println("Total students created: " + Student.getCount());
    }
}