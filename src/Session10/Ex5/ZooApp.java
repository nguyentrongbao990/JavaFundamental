package Session10.Ex5;

import java.util.Scanner;

public class ZooApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tạo sẵn đối tượng trước để dùng cho mọi chức năng
        Dog dog = new Dog("Buddy", 3, true);
        Cat cat = new Cat("Mimi", 2, true);
        Elephant elephant = new Elephant("Dumbo", 10, false);

        Animal[] animals = {dog, cat, elephant};

        while (true) {
            System.out.println("===== ZOO MANAGEMENT MENU =====");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin");
            System.out.println("2. Kiểm tra Overriding: makeSound()");
            System.out.println("3. Kiểm tra Overloading: eat()");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng từng loài");
            System.out.println("0. Thoát");
            System.out.println("================================");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                System.out.println();
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("--- THÔNG TIN CÁC ĐỘNG VẬT ---");
                    dog.showInfo();
                    cat.showInfo();
                    elephant.showInfo();
                    break;

                case 2:
                    System.out.println("--- OVERRIDING: makeSound() ---");
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;

                case 3:
                    System.out.println("--- OVERLOADING: eat() ---");
                    dog.eat();
                    dog.eat("meat");
                    cat.eat("fish");
                    elephant.eat();
                    break;

                case 4:
                    System.out.println("--- POLYMORPHISM RUNTIME ---");
                    for (Animal animal : animals) {
                        animal.makeSound();
                    }
                    break;

                case 5:
                    System.out.println("--- PHƯƠNG THỨC RIÊNG CỦA TỪNG LOÀI ---");
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    sc.close();
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ.");
            }

            System.out.println();
        }
    }
}