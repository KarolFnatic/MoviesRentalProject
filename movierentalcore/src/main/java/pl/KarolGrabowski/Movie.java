package pl.KarolGrabowski;

public class Movie {
    private static int nextId = 0;
    private int id;
    private String title;
    private String genre;
    private String description;

    public Movie(String title, String genre, String description) {
        id = nextId;
        nextId++;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}