package Session13.Ex2;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    private final ArrayList<Student> students = new ArrayList<>();

    @Override
    public void add(Student item) {
        students.add(item);
    }

    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < students.size()) {
            students.set(index, item);
        } else {
            System.out.println("Vị trí cập nhật không hợp lệ.");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        } else {
            System.out.println("Vị trí xóa không hợp lệ.");
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isDuplicateId(int id) {
        return findIndexById(id) != -1;
    }

    public int size() {
        return students.size();
    }
}