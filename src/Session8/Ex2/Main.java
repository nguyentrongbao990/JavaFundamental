package Session8.Ex2;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Giáo trình valorant từ a - z","Biao",1000000.00);
        System.out.println("Title: "+book.getTitle()+", Author: "+book.getAuthor()+", Price: "+book.getPrice());
    }
}
