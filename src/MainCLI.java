import java.util.*;

public class MainCLI {
    public static void main(String[] args) {

        LoginCLI login = new LoginCLI();
        if (!login.login()) return;

        Scanner sc = new Scanner(System.in);
        MediaVault vault = new MediaVault();
        Recommender rec = new Recommender();

        
        vault.loadFromFile(LoginCLI.currentUser);

        System.out.println("------------Welcome To The Personal Movie/Media Vault App------------");

        while (true) {
            System.out.println("\n1.AddMovie 2.TopRated 3.FilterByGenre 4.Recommend 5.Show 6.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            try {
                switch (ch) {

                    case 1:
                        System.out.print("Movie Title: ");
                        String t = sc.nextLine();

                        System.out.print("Year: ");
                        int y = sc.nextInt(); sc.nextLine();

                        System.out.print("Genre: ");
                        String g = sc.nextLine();

                        System.out.print("Rating: ");
                        double r = sc.nextDouble(); sc.nextLine();

                        System.out.print("Review: ");
                        String rev = sc.nextLine();

                        if (r < 0 || r > 10)
                            throw new InvalidRatingException("Invalid Rating!");

                        vault.addMovie(new UserRating(
                                LoginCLI.currentUser,
                                t, y, g, r, rev
                        ));
                        break;

                    case 2:
                        vault.getTopRated();
                        break;

                    case 3:
                        System.out.print("Genre: ");
                        vault.filterByGenre(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Fav Genre: ");
                        rec.recommend(vault.getMovies(), sc.nextLine());
                        break;

                    case 5:
                        vault.showUserMovies(); 
                        break;

                    case 6:
                        System.out.println("bye see you agian!");
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
