package Session15.Ex1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieManager<T extends Movie> {
    private List<T> movies;

    public MovieManager() {
        movies = new ArrayList<>();
    }

    public boolean addMovie(T movie) {
        if (findById(movie.getId()) != null) {
            return false;
        }
        movies.add(movie);
        return true;
    }

    public boolean removeMovieById(String id) {
        T movie = findById(id);
        if (movie == null) {
            return false;
        }
        movies.remove(movie);
        return true;
    }

    public boolean updateMovie(String id, String title, String director, LocalDate releaseDate, double rating) {
        T movie = findById(id);
        if (movie == null) {
            return false;
        }

        movie.setTitle(title);
        movie.setDirector(director);
        movie.setReleaseDate(releaseDate);
        movie.setRating(rating);
        return true;
    }

    public T findById(String id) {
        for (T movie : movies) {
            if (movie.getId().equalsIgnoreCase(id)) {
                return movie;
            }
        }
        return null;
    }

    public List<T> searchByTitle(String keyword) {
        List<T> result = new ArrayList<>();
        for (T movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<T> filterByRating(double minRating) {
        List<T> result = new ArrayList<>();
        for (T movie : movies) {
            if (movie.getRating() > minRating) {
                result.add(movie);
            }
        }
        return result;
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("Danh sách phim đang trống.");
            return;
        }

        System.out.println("Danh sách phim:");
        for (T movie : movies) {
            System.out.println(movie);
        }
    }
}