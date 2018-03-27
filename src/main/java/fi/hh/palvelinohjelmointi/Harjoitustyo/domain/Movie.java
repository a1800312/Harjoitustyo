package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long movieId;
	
	@NotNull
	@Size(min=1, max=255)
	private String movieName;
	
	@NotNull
	@Size(min=1, max=50)
	private String movieLength;
	
	@NotNull
	@Size(min=1, max=255)
	private String movieIMDBURL;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "movieReviewId")
	private MovieReview moviereview;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "starId")
	private Stars stars;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "yearId")
	private Year year;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "actorId")
	private Actor actor;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "genreId")
	private Genre genre;
	
	public Movie () {
		
	}
	
	public Movie(Long movieId, String movieName, String movieLength, String movieIMDBURL, MovieReview moviereview,
			Stars stars, Year year, Actor actor, Genre genre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLength = movieLength;
		this.movieIMDBURL = movieIMDBURL;
		this.moviereview = moviereview;
		this.stars = stars;
		this.year = year;
		this.actor = actor;
		this.genre = genre;
	}

	public Movie(String movieName, String movieLength, String movieIMDBURL, MovieReview moviereview,
			Stars stars, Year year, Actor actor, Genre genre) {
		super();
		this.movieName = movieName;
		this.movieLength = movieLength;
		this.movieIMDBURL = movieIMDBURL;
		this.moviereview = moviereview;
		this.stars = stars;
		this.year = year;
		this.actor = actor;
		this.genre = genre;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}

	public String getMovieIMDBURL() {
		return movieIMDBURL;
	}

	public void setMovieIMDBURL(String movieIMDBURL) {
		this.movieIMDBURL = movieIMDBURL;
	}
	
	public MovieReview getMoviereview() {
		return moviereview;
	}

	public void setMoviereview(MovieReview moviereview) {
		this.moviereview = moviereview;
	}

	public Stars getStars() {
		return stars;
	}

	public void setStars(Stars stars) {
		this.stars = stars;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieLength=" + movieLength
				+ ", movieIMDBURL=" + movieIMDBURL + "]";
	}
}
