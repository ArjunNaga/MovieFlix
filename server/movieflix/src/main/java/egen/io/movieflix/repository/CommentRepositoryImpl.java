package egen.io.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public Comment create(Movie movie, User user) {
	
		Movie m = movieRepository.findOne(movie.getId());
		User u = userRepository.findOne(user.getId());
		Comment mu = ((CommentRepositoryImpl) em).create(m, u);
	    em.persist(mu);
	    return mu; 
	}
 

	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}
 
}
