package egen.io.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.exception.MovieAlreadyExistException;
import egen.io.movieflix.exception.MovieNotFoundException;
import egen.io.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findOne(String movieId) {
		Movie movie = movieRepository.findOne(movieId);
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return movie;
	}

	@Transactional
	@Override
	public Movie create(Movie movie) {
		Movie existing = movieRepository.findByName(movie.getMovieName());
		if (existing != null) {
			throw new MovieAlreadyExistException("Movie already exists");
		}
		return movieRepository.create(movie);
	}

	@Transactional
	@Override
	public Movie update(String movieId, Movie movie) {
		Movie existing = movieRepository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return movieRepository.update(movie);
	}

	@Transactional
	@Override
	public void remove(String movieId) {
		Movie existing = movieRepository.findOne(movieId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		movieRepository.delete(existing);
	}
}