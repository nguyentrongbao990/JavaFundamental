package Session15.Ex1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManager<Movie> movieManager = new MovieManager<>();

        movieManager.addMovie(new Movie("01", "Na Tra", "Nguyễn Công Hưởng", LocalDate.of(2025, 2, 23), 9.5));
        movieManager.addMovie(new Movie("02", "Tây Du Ký", "Không biết", LocalDate.of(1973, 1, 1), 7.9));

        int choice;

        do {
            showMenu();

            try {
                System.out.print("Chọn chức năng: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addMovie(scanner, movieManager);
                        break;
                    case 2:
                        removeMovie(scanner, movieManager);
                        break;
                    case 3:
                        updateMovie(scanner, movieManager);
                        break;
                    case 4:
                        movieManager.displayMovies();
                        break;
                    case 5:
                        searchMovieByTitle(scanner, movieManager);
                        break;
                    case 6:
                        filterMovieByRating(scanner, movieManager);
                        break;
                    case 7:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                choice = -1;
            }

        } while (choice != 7);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\nChọn chức năng:");
        System.out.println("1. Thêm phim");
        System.out.println("2. Xóa phim");
        System.out.println("3. Sửa phim");
        System.out.println("4. Hiển thị phim");
        System.out.println("5. Tìm kiếm phim theo tên");
        System.out.println("6. Lọc phim theo rating");
        System.out.println("7. Thoát");
    }

    public static void addMovie(Scanner scanner, MovieManager<Movie> movieManager) {
        System.out.print("Nhập ID phim: ");
        String id = scanner.nextLine();

        if (movieManager.findById(id) != null) {
            System.out.println("ID phim đã tồn tại!");
            return;
        }

        System.out.print("Nhập tiêu đề phim: ");
        String title = scanner.nextLine();

        System.out.print("Nhập đạo diễn: ");
        String director = scanner.nextLine();

        LocalDate releaseDate = inputReleaseDate(scanner);
        double rating = inputRating(scanner);

        Movie movie = new Movie(id, title, director, releaseDate, rating);
        if (movieManager.addMovie(movie)) {
            System.out.println("Phim đã được thêm thành công.");
        } else {
            System.out.println("Thêm phim thất bại.");
        }
    }

    public static void removeMovie(Scanner scanner, MovieManager<Movie> movieManager) {
        System.out.print("Nhập ID phim cần xóa: ");
        String id = scanner.nextLine();

        if (movieManager.removeMovieById(id)) {
            System.out.println("Phim đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy phim muốn xóa!");
        }
    }

    public static void updateMovie(Scanner scanner, MovieManager<Movie> movieManager) {
        System.out.print("Mời nhập ID phim muốn sửa: ");
        String id = scanner.nextLine();

        Movie movie = movieManager.findById(id);
        if (movie == null) {
            System.out.println("Không tìm thấy phim với id = " + id);
            return;
        }

        System.out.print("Nhập tiêu đề phim: ");
        String title = scanner.nextLine();

        System.out.print("Nhập đạo diễn: ");
        String director = scanner.nextLine();

        LocalDate releaseDate = inputReleaseDate(scanner);
        double rating = inputRating(scanner);

        if (movieManager.updateMovie(id, title, director, releaseDate, rating)) {
            System.out.println("Cập nhật phim thành công!");
        } else {
            System.out.println("Cập nhật thất bại!");
        }
    }

    public static void searchMovieByTitle(Scanner scanner, MovieManager<Movie> movieManager) {
        System.out.print("Nhập tiêu đề phim để tìm kiếm: ");
        String keyword = scanner.nextLine();

        List<Movie> result = movieManager.searchByTitle(keyword);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy phim");
        } else {
            System.out.println("Phim tìm thấy:");
            for (Movie movie : result) {
                System.out.println(movie);
            }
        }
    }

    public static void filterMovieByRating(Scanner scanner, MovieManager<Movie> movieManager) {
        double minRating;

        while (true) {
            try {
                System.out.print("Nhập rating tối thiểu để lọc: ");
                minRating = Double.parseDouble(scanner.nextLine());

                if (minRating < 0 || minRating > 10) {
                    System.out.println("Lỗi: Rating phải nằm trong khoảng 0 đến 10!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập rating là số!");
            }
        }

        List<Movie> result = movieManager.filterByRating(minRating);

        if (result.isEmpty()) {
            System.out.println("Không có phim nào thỏa mãn.");
        } else {
            System.out.println("Phim có rating lớn hơn " + minRating + ":");
            for (Movie movie : result) {
                System.out.println(movie);
            }
        }
    }

    public static LocalDate inputReleaseDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập ngày phát hành (yyyy-MM-dd): ");
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Ngày phải đúng định dạng yyyy-MM-dd!");
            }
        }
    }

    public static double inputRating(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập rating: ");
                double rating = Double.parseDouble(scanner.nextLine());

                if (rating < 0 || rating > 10) {
                    System.out.println("Lỗi: Rating phải nằm trong khoảng 0 đến 10!");
                    continue;
                }

                return rating;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Rating phải là số!");
            }
        }
    }
}