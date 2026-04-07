package Session16.Ex5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Nguyen Van A", "IT", 8.5));
        students.add(new Student("Tran Thi B", "Business", 7.8));
        students.add(new Student("Le Van C", "IT", 9.0));
        students.add(new Student("Pham Thi D", "Marketing", 8.1));
        students.add(new Student("Hoang Van E", "IT", 7.5));
        students.add(new Student("Vo Thi F", "Design", 8.0));
        students.add(new Student("Do Van G", "Business", 6.9));
        students.add(new Student("Bui Thi H", "Marketing", 8.7));
        students.add(new Student("Dang Van I", "IT", 7.2));
        students.add(new Student("Nguyen Thi K", "Design", 9.1));
        students.add(new Student("Tran Van L", "Business", 7.4));

        Map<String, Long> statistics = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.counting()
                ));

        Map<String, Long> sortedStatistics = statistics.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("===== THỐNG KÊ SỐ LƯỢNG SINH VIÊN THEO CHUYÊN NGÀNH =====");
        sortedStatistics.forEach((major, count) -> {
            System.out.println("Chuyên ngành: " + major);
            System.out.println("Số lượng sinh viên: " + count);
            System.out.println("-----------------------------------");
        });
    }
}