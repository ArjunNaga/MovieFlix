package egen.io.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.io.movieflix.entity.Movie;

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
		System.out.println(movieId);
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByName(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByName", Movie.class);
		query.setParameter("ptitle", title);
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

	@Override
	public List<Movie> findByType(String movieType) {
		System.out.println("Repository");
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("ptype", movieType);
	    return query.getResultList();		
}
}
