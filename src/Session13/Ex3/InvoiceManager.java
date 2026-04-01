package Session13.Ex3;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {
    private final ArrayList<Invoice> invoices = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoices.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < invoices.size()) {
            invoices.set(index, item);
        } else {
            System.out.println("Vị trí cập nhật không hợp lệ.");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoices.size()) {
            invoices.remove(index);
        } else {
            System.out.println("Vị trí xóa không hợp lệ.");
        }
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn đang trống.");
            return;
        }

        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isDuplicateId(int id) {
        return findIndexById(id) != -1;
    }

    public int size() {
        return invoices.size();
    }
}