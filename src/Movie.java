class Movie {
    protected String title;
    protected int year;
    protected String genre;
    protected double rating;

    public Movie(String title, int year, String genre, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    public String toString() {
        return title + " (" + year + ") | " + genre + " | Rating: " + rating;
    }
}