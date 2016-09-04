package Movieflix.repository;

import java.util.List;

import Movieflix.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie existing);

	public Movie findByName(String movieName);
}
