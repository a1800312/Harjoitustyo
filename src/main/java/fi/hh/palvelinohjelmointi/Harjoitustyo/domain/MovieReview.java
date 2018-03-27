package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieReview {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long movieReviewId;
	
	@NotNull
	@Size(min=1, max=100)
	private String reviewName;
	
	@NotNull
	@Size(min=1, max=255)
	private String reviewText;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "moviereview")
	private List<Movie> movies;
	
	public MovieReview () {
		
	}

	public MovieReview(Long movieReviewId, String reviewName, String reviewText) {
		super();
		this.movieReviewId = movieReviewId;
		this.reviewName = reviewName;
		this.reviewText = reviewText;
	}
	
	public MovieReview(String reviewName, String reviewText) {
		super();
		this.reviewName = reviewName;
		this.reviewText = reviewText;
	}

	public Long getMovieReviewId() {
		return movieReviewId;
	}

	public void setMovieReviewId(Long movieReviewId) {
		this.movieReviewId = movieReviewId;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "MovieReview [movieReviewId=" + movieReviewId + ", reviewName=" + reviewName + ", reviewText="
				+ reviewText + ", movies=" + movies + "]";
	}
}
