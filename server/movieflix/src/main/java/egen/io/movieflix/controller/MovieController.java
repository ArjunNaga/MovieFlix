package egen.io.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egen.io.movieflix.entity.Movie;
import egen.io.movieflix.service.MovieService;

@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

	@Autowired
	private MovieService movieService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public List <Movie> findAll() {
		return movieService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public  Movie findOne(@PathVariable("id") String movieId) {
		return movieService.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Movie create(@RequestBody Movie movie) {
		return movieService.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie) {
		return movieService.update(movieId,movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String movieId) {
		movieService.remove(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET,params ="type") 
	public List<Movie> findByType(@RequestParam("type") String movieType) {
		System.out.println("Controller");
		return movieService.findByType(movieType); 
		} 
		
}