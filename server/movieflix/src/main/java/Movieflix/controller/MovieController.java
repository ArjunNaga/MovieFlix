package Movieflix.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Movieflix.entity.Movie;

@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@RequestMapping(method = RequestMethod.GET)
	public List <Movie> findAll() {
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public  Movie findOne() {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Movie create() {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Movie update() {
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete() {
	}
}