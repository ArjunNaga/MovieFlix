package Movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Movie {

	private String id;
	private String movieName;
	private String movieDirector;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
}
