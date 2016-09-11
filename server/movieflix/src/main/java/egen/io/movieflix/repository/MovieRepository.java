package egen.io.movieflix.repository;

import java.util.List;

import egen.io.movieflix.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String movieId);

	public Movie create(Movie movie);

	public Movie update(Movie movie);

	public void delete(Movie existing);

	public Movie findByName(String movieName);
	
	public List<Movie> findByType(String movieType);

	public List<Movie> findByGenre(String movieGenre);
	
	public List<Movie> findByYear(int movieYear);

}
  