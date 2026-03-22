package Session8.Ex5;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private double gpa;
    private static int countStudent=0;
    final double SCORE_FACTOR=0.25;
    public Student(){
        countStudent++;
    }
    public Student(int id, String name, double gpa) {
        this();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
    public static int getTotalStudent(){
        return countStudent;
    }
    public void input(Scanner input){
        System.out.println("Please enter your id:");
        id = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your name:");
        name = input.nextLine();
        System.out.println("Please enter your gpa:");
        gpa = Double.parseDouble(input.nextLine());
    }
    public void print(){
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student GPA: " + gpa);
    }
}
