package Movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import Movieflix.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByName(String movieName) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByName", Movie.class);
		query.setParameter("pmovieName", movieName);
		List<Movie> movies = query.getResultList();
		if (movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie existing) {
		em.remove(existing);
	}

}
