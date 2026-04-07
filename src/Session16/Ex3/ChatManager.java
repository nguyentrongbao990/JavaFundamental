package Session16.Ex3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatManager {
    private List<Message> messages;

    public ChatManager() {
        messages = new ArrayList<>();
    }

    public void sendMessage(String sender, String content) {
        Message message = new Message(sender, content, LocalDateTime.now());
        messages.add(message);
    }

    public void showChatHistory() {
        if (messages.isEmpty()) {
            System.out.println("Lịch sử chat đang trống.");
            return;
        }

        System.out.println("Lịch sử chat:");
        messages.forEach(System.out::println);
    }

    public List<Message> filterBySender(String sender) {
        return messages.stream()
                .filter(message -> message.getSender().equalsIgnoreCase(sender))
                .collect(Collectors.toList());
    }

    public List<Message> filterByDate(LocalDate date) {
        return messages.stream()
                .filter(message -> message.getTimestamp().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}