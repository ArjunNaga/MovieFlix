package egen.io.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.entity.Comment;
import egen.io.movieflix.entity.User;
import egen.io.movieflix.service.CommentService;

@RestController
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {

	@Autowired
	private CommentService movie_userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List <Comment> findAll() {
		return movie_userService.findAll(); 
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(String movieId, String userId, String message){
		return movie_userService.create(movieId, userId, message);
	}
	
	

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public  Comment findOne(@PathVariable("id") String commentId) {
		return movie_userService.findOne(commentId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Comment update(@PathVariable("id") String commentId, @RequestBody Comment comment) {
		return movie_userService.update(commentId,comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String commentId) {
		movie_userService.remove(commentId); 
	}
}