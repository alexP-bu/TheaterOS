package theateros;

import java.io.Serializable;

public class Movie implements Serializable{
    private String name;
    private String genre;
    private String rating;
    private int duration;

    public Movie(String name, String genre, int duration, String rating){
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "Movie: " + name + " Genre: " + genre + " Rated: " + rating + " Duration " + duration + " minutes";
    }
}
