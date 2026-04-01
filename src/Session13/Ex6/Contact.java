package Session13.Ex6;

import java.util.Objects;

public class Contact {
    private static int AUTO_ID = 1;

    private int id;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String name, String phoneNumber) {
        this.id = AUTO_ID++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    private Contact(String phoneNumber, boolean probe) {
        this.phoneNumber = phoneNumber;
    }

    public static Contact probeByPhone(String phoneNumber) {
        return new Contact(phoneNumber, true);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | SĐT: " + phoneNumber;
    }
}