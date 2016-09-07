package egen.io.movieflix.service;

import java.util.List;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.User;

public interface CommentService {

	public Comment create(Movie movie, User user);

	public List<Comment> findAll();
	
	

}
