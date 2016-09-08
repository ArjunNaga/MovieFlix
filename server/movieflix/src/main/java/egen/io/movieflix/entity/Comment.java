package egen.io.movieflix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Comment.findAll", query = "SELECT c from Comment c")
})
public class Comment {

	@Id
	@Column(name = "COMMENT_ID")
	private String id;
	private String message;
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Comment(){
		id = UUID.randomUUID().toString();	
		System.out.println(id + " constructor ");
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println(id + " set");
	}

	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	private Movie movie;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	
	
}
