package Session16.Ex2;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện đang trống.");
            return;
        }

        System.out.println("Danh sách sự kiện:");
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public void checkEventStatus() {
        if (events.isEmpty()) {
            System.out.println("Không có sự kiện nào để kiểm tra.");
            return;
        }

        System.out.println("Trạng thái các sự kiện:");
        for (Event event : events) {
            System.out.println("Tên sự kiện: " + event.getName());
            System.out.println("Trạng thái: " + event.getStatus());
            System.out.println("----------------------------");
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}