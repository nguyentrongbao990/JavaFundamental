package Session13.Ex6;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContactManager {
    private final Set<Contact> contacts = new LinkedHashSet<>();

    public void addContact(Contact contact) {
        boolean added = contacts.add(contact);
        if (added) {
            System.out.println("Thêm liên lạc thành công.");
        } else {
            System.out.println("Số điện thoại đã tồn tại.");
        }
    }

    public void removeByPhone(String phoneNumber) {
        boolean removed = contacts.remove(Contact.probeByPhone(phoneNumber));
        if (removed) {
            System.out.println("Xóa liên lạc thành công.");
        } else {
            System.out.println("Không tìm thấy liên lạc.");
        }
    }

    public Contact searchByPhone(String phoneNumber) {
        Contact probe = Contact.probeByPhone(phoneNumber);

        if (!contacts.contains(probe)) {
            return null;
        }

        for (Contact contact : contacts) {
            if (contact.equals(probe)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ đang trống.");
            return;
        }

        System.out.println("Danh sách liên lạc:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }
}