import java.io.*;
import java.util.*;

class MediaVault {
    private List<UserRating> movies = new ArrayList<>();

    public void addMovie(UserRating m) {
        movies.add(m);
        saveToFile(m);
    }

    public List<UserRating> getMovies() {
        return movies;
    }

    public void filterByGenre(String genre) {
        for (UserRating m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(m);
            }
        }
    }

    public void getTopRated() {
        movies.stream()
              .sorted((a, b) -> Double.compare(b.getRating(), a.getRating()))
              .limit(5)
              .forEach(System.out::println);
    }

    
    private void saveToFile(UserRating movie) {
        try {
            String filename = "data/" + movie.getUsername().trim() + ".txt";

            File file = new File(filename);
            file.getParentFile().mkdirs(); // ensure folder exists
            file.createNewFile();          // create file if not exists

            FileWriter fw = new FileWriter(file, true);
            fw.write(movie.toFileString() + "\n");
            fw.close();

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

   
    public void loadFromFile(String username) {
        movies.clear();

        try {
            String filename = "data/" + username.trim() + ".txt";

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                movies.add(new UserRating(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        parts[3],
                        Double.parseDouble(parts[4]),
                        parts[5]
                ));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("No data found for this user.");
        }
    }

   
    public void showUserMovies() {
        if (movies.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (UserRating movie : movies) {
                System.out.println(movie);
            }
        }
    }
}