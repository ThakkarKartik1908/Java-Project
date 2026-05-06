
import java.util.List;

class Recommender {

    public void recommend(List<UserRating> movies, String genre) {
        UserRating best = null;

        for (UserRating m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                if (best == null || m.getRating() > best.getRating()) {
                    best = m;
                }
            }
        }

        if (best != null)
            System.out.println("Recommended:\n" + best);
        else
            System.out.println("No recommendation found.");
    }
}