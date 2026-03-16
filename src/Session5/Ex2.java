package Session5;
public class Ex2 {
    public static void main(String[] args) {
        int n = 1_000_000;

        // 1. Đo với String
        long startString = System.currentTimeMillis();
        String str = "Hello";
        for (int i = 0; i < n; i++) {
            str += " World";
        }
        long endString = System.currentTimeMillis();

        // 2. Đo với StringBuilder
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < n; i++) {
            sb.append(" World");
        }
        long endBuilder = System.currentTimeMillis();

        // 3. Đo với StringBuffer
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < n; i++) {
            sbf.append(" World");
        }
        long endBuffer = System.currentTimeMillis();

        // In thời gian thực thi
        System.out.println("Thời gian thực hiện với String: " + (endString - startString) + " ms");
        System.out.println("Thời gian thực hiện với StringBuilder: " + (endBuilder - startBuilder) + " ms");
        System.out.println("Thời gian thực hiện với StringBuffer: " + (endBuffer - startBuffer) + " ms");

        // In độ dài để đảm bảo các phép nối thật sự đã diễn ra
        System.out.println("Độ dài String: " + str.length());
        System.out.println("Độ dài StringBuilder: " + sb.length());
        System.out.println("Độ dài StringBuffer: " + sbf.length());

        // Nhận xét
        System.out.println("\nNhận xét:");
        System.out.println("- String: chậm nhất vì mỗi lần nối tạo ra đối tượng mới.");
        System.out.println("- StringBuilder: nhanh nhất, phù hợp khi nối chuỗi nhiều trong một luồng.");
        System.out.println("- StringBuffer: cũng nhanh nhưng chậm hơn StringBuilder vì có đồng bộ hóa, phù hợp khi nhiều luồng cùng truy cập.");
    }
}
