package egen.io.movieflix.repository;

import java.util.List;
import java.util.UUID;

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
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

    @Override
	public Comment create(Comment comment) {
    	
    	System.out.println("Hello");
    	em.persist(comment);
    	return comment;
    	
    	
    	
/*	     System.out.println(x);
		Comment c = new Comment();
		Movie m = movieRepository.findOne(movieId);
		User u = userRepository.findOne(userId);
		c.setMovie(m);
		c.setUser(u);
		c.setMessage(message);
		em.persist(c);
		return c;
		
			Movie m = movieRepository.findOne(movie.getId());
		User u = userRepository.findOne(user.getId());
		Comment c = ((CommentRepositoryImpl) em).create(m, u);
	   // em.persist(c);
	    //return c; 
*/	
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
    
}







