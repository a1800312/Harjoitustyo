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
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long genreId;
	
	@NotNull
	@Size(min=1, max=100)
	private String genreName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="genre")
	private List<Movie> movie;
	
	public Genre() {
		
	}

	public Genre(Long genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}
	
	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", movie=" + movie + "]";
	}
}
