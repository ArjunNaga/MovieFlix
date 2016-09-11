package egen.io.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired(required = false)
	private Movie movie;
	

	@Autowired(required = false)
	private User user;
	
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

    @Override
	public Comment create(Comment comment) {
    	em.persist(comment);
    	return comment;
    }

	@Override
	public Comment findOne(String commentId) {
		return em.find(Comment.class, commentId);
	}
	
	@Override
	public void delete(Comment existing) {
		em.remove(existing);
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public List<Comment> findByMovie(String movieId, String userId) {
		System.out.println("Repository");
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovie", Comment.class);
		movie.setId(movieId);
		user.setId(userId);
		query.setParameter("pmovie", movie);
		query.setParameter("puser", user);
		return query.getResultList();	 
    }
}







