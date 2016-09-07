package egen.io.movieflix.service;

import java.util.List;

import egen.io.movieflix.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void remove(String movieId);
	
}
