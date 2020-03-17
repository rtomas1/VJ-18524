package ba.unsa.etf.rma.vj_18524;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MoviesModel {
    private List<Movie> movies=new ArrayList<>();
    private static MoviesModel instance = null;

    public MoviesModel() {
        movies.add(new Movie("Reservoir dogs","Crime","1992","https://www.imdb.com/title/tt0105236/","Six criminals, who are strangers to each other, are hired by a crime boss, Joe Cabot, to carry out a diamond robbery. Robbery goes wrong, the police shows up, and two robbers get killed, and they begin to suspect that one of them is an undercover cop."));
        movies.add(new Movie("Fight Club", "Drama", "1999", "https://www.imdb.com/title/tt0137523/", "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more."));
    }

    public MoviesModel(List<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return (ArrayList<Movie>) movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public static MoviesModel getInstance(){
        if(instance == null) instance = new MoviesModel();
        return instance;
    }
}
