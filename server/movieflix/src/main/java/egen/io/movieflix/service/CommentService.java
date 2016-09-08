package egen.io.movieflix.service;

import java.util.List;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.User;

public interface CommentService {


	public List<Comment> findAll();
	

	public Comment create(String commentId, String userId, String message);


	public Comment findOne(String commentId);


	public void remove(String commentId);


	public Comment update(String commentId, Comment comment); 

}
