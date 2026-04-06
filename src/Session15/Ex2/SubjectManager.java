package Session15.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager<T extends Subject> {
    private List<T> subjects;

    public SubjectManager() {
        subjects = new ArrayList<>();
    }

    public void addSubject(T subject) {
        if (findByCode(subject.getCode()).isPresent()) {
            throw new IllegalArgumentException("Mã môn học đã tồn tại!");
        }
        subjects.add(subject);
    }

    public void removeSubjectByCode(String code) {
        boolean removed = subjects.removeIf(subject ->
                subject.getCode().equalsIgnoreCase(code));

        if (!removed) {
            throw new IllegalArgumentException("Không tìm thấy môn học với code: " + code);
        }
    }

    public void displayAllSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học đang trống.");
            return;
        }

        System.out.println("Danh sách môn học:");
        subjects.forEach(System.out::println);
    }

    public Optional<T> searchByName(String keyword) {
        return subjects.stream()
                .filter(subject -> subject.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .findFirst();
    }

    public List<T> filterByCreditsGreaterThan(int minCredits) {
        return subjects.stream()
                .filter(subject -> subject.getCredits() > minCredits)
                .collect(Collectors.toList());
    }

    public Optional<T> findByCode(String code) {
        return subjects.stream()
                .filter(subject -> subject.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public List<T> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<T> subjects) {
        this.subjects = subjects;
    }
}