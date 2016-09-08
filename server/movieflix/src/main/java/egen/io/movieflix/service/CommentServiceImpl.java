package egen.io.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;
import egen.io.movieflix.exception.MovieAlreadyExistException;
import egen.io.movieflix.exception.MovieNotFoundException;
import egen.io.movieflix.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
	private CommentRepository movie_userRepository;
    
	@Override
	public List<Comment> findAll() {
		return movie_userRepository.findAll();
	}

	@Override
	public Comment create(String movieId, String userId, String message) {
		
		Comment existing = movie_userRepository.create(movieId, userId, message);
		if (existing != null) { 
			throw new MovieAlreadyExistException("Comment already exists"); 
		}
		return movie_userRepository.create(movieId, userId, message);
	}

	@Override
	public Comment findOne(String commentId) {
		Comment comment = movie_userRepository.findOne(commentId);
		if (comment == null) {
			throw new MovieNotFoundException("Comment not found");
		}
		return comment;
	}
	
	@Transactional
	@Override
	public Comment update(String commentId, Comment comment) {
		Comment existing = movie_userRepository.findOne(commentId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return movie_userRepository.update(comment);
	}

	@Transactional
	@Override
	public void remove(String commentId) {
		Comment existing = movie_userRepository.findOne(commentId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		movie_userRepository.delete(existing);
	}

}
