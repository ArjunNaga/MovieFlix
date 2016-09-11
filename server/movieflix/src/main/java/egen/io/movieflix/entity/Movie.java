package egen.io.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m"),
	@NamedQuery(name = "Movie.findByName", query = "SELECT m from Movie m where m.Title=:ptitle"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m from Movie m where m.Type=:ptype"),
	@NamedQuery(name = "Movie.findByGenre", query = "SELECT m from Movie m where m.Genre=:pgenre"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m from Movie m where m.Year=:pyear")
})
public class Movie {

	@Id
	@Column(name = "MOVIE_ID")
	private String id; 
	
	@Column(unique = true, nullable=false)
    private String Title;
	@Column(nullable=false)
    private int Year;
    private String Rated;
	@Column(nullable=false)
    private String Released;
	@Column(nullable=false)
    private String Runtime;
	@Column(nullable=false)
    private String Genre;
	@Column(nullable=false)
    private String Director;
	@Column(nullable=false)
    private String Writer;
	@Column(nullable=false)
    private String Actors;
	@Column(nullable=false)
    private String Plot;
	@Column(nullable=false)
    private String Language;
	@Column(nullable=false)
    private String Country;
    private String Awards;
	@Column(nullable=false, unique = true)
    private String Poster;
    private int Metascore;
    private double imdbRating;
    private long imdbVotes;
    @Column(unique = true)
    private String imdbID;
	@Column(nullable=false)
    private String Type;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getRated() {
		return Rated;
	}

	public void setRated(String rated) {
		Rated = rated;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		Actors = actors;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public int getMetascore() {
		return Metascore;
	}

	public void setMetascore(int metascore) {
		Metascore = metascore;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public long getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToMany
	private List<User> users;

	public Movie(){
	id = UUID.randomUUID().toString();
	}
}
