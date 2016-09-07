package egen.io.movieflix.repository;

import java.util.List;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;

public interface CommentRepository {

	public Comment create(Movie movie, User user);

	public List<Comment> findAll();
	
}
