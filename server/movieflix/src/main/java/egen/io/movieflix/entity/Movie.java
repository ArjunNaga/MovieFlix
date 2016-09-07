package egen.io.movieflix.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m ORDER BY m.movieName"),
	@NamedQuery(name = "Movie.findByName", query = "SELECT m from Movie m where m.movieName=:pmovieName")
})
public class Movie {

	@Id
	@Column(name = "MOVIE_ID")
	private String id; 
	
	@Column(unique = true)
	private String movieName;
	private String movieDirector;
	private String movieGenre;
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	

	public Movie(){
	id = UUID.randomUUID().toString();
	}
	
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
	
	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@SuppressWarnings("deprecation")
	public String getReleaseDate() {
		return releaseDate.toLocaleString();
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieDirector=" + movieDirector + ", movieGenre="
				+ movieGenre + "]";
	}
	
	
}
