package Session9.Ex2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James", 100.0);
        Book b2 = new Book("Python", "Guido", 120.0);
        Book b3 = new Book("C++", "Bjarne", 150.0);

        ArrayList<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        System.out.println("----- LIST OF BOOKS -----");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).printInfo();
        }
    }
}