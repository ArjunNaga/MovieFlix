package egen.io.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.User;
import egen.io.movieflix.exception.MovieAlreadyExistException;
import egen.io.movieflix.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
	private CommentRepository movie_userRepository;

    @Override
	public Comment create(Movie movie, User user) {
		Comment existing = movie_userRepository.create(movie, user);
		if (existing != null) { 
			throw new MovieAlreadyExistException("Movie already exists");
		}
		return movie_userRepository.create(movie,user);
	}

	@Override
	public List<Comment> findAll() {
		return movie_userRepository.findAll();
	}

}
