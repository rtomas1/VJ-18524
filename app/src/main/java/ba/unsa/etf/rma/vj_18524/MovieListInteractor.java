package ba.unsa.etf.rma.vj_18524;

import java.util.ArrayList;

public class MovieListInteractor {
    private MoviesModel model;
    public MovieListInteractor(){
        model = new MoviesModel();
    }
    public ArrayList<Movie> get(){
        return model.getMovies();
    }

}
