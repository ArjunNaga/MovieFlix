package egen.io.movieflix.service;

import java.util.List;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.Rating;

public interface MovieService {

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void remove(String movieId);

	public List<Movie> findByType(String movieType);

	public List<Movie> findAll(); 
	
}
