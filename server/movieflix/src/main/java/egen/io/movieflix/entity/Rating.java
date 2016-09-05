package egen.io.movieflix.entity;



import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findAll", query = "SELECT r from Rating r"),
	@NamedQuery(name = "Rating.findByRanking", query = "SELECT r from Rating r where r.movieRanking=:pmovieRanking")
	})
public class Rating {

@Id
@Column(name = "RATING_ID")
private String id; 

private String ratingGrade;
private double averageRating;
public double getAverageRating() {
	return averageRating;
}


public void setAverageRating(double averageRating) {
	this.averageRating = averageRating;
}
@Column(unique = true)
private int movieRanking;

public Rating(){
	id = UUID.randomUUID().toString();
	}


public String getId() {
	return id;
}


public int getMovieRanking() {
	return movieRanking;
}
public void setMovieRanking(int movieRanking) {
	this.movieRanking = movieRanking;
}
public void setId(String id) {
	this.id = id;
}
public String getRatingGrade() {
	return ratingGrade;
}

public void setRatingGrade(String ratingGrade) {
	this.ratingGrade = ratingGrade;
}


@Override
public String toString() {
	return "Rating [id=" + id + ", ratingGrade=" + ratingGrade + ", averageRating=" + averageRating + ", movieRanking="
			+ movieRanking + "]";
}







}