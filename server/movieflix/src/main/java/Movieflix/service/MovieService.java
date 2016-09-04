package Movieflix.service;

import java.util.List;

import Movieflix.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void remove(String movieId);
	
}
