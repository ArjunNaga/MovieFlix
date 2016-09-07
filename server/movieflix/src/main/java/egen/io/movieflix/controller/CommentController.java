package egen.io.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

		/*
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public  Movies_Users findOne(@PathVariable("id") String movieId) {
		return movie_userService.findOne(movieId);
	}*/

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Comment create(@RequestBody Comment movie_user,@RequestBody Movie movie,@RequestBody User user) {
		return movie_userService.create(movie, user);
	}

/*	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Movies_Users update(@PathVariable("id") String movieId, @RequestBody Movie movie) {
		return movie_userService.update(movieId,movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String movieId) {
		movie_userService.remove(movieId);
	}*/
}