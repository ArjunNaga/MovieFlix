package egen.io.movieflix.repository;

import java.util.List;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;

public interface CommentRepository {


	public List<Comment> findAll();

	public Comment create(String movieId, String userId, String message);

	public Comment findOne(String commentId);

	public void delete(Comment existing);

	public Comment update(Comment comment);
	
}
