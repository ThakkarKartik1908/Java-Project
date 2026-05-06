class UserRating extends Movie {
    private String review;
    private String username;

    public UserRating(String username, String title, int year, String genre, double rating, String review) {
        super(title, year, genre, rating);
        this.username = username;
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public String getReview() {
        return review;
    }

    public String toString() {
        return username + " -> " + super.toString() + " | Review: " + review;
    }

    public String toFileString() {
        return username + "," + title + "," + year + "," + genre + "," + rating + "," + review;
    }
}