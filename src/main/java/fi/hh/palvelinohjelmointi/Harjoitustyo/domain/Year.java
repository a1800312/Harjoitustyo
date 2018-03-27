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
public class Year {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long yearId;
	
	@NotNull
	@Size(min=4, max=4)
	private String yearName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="year")
	private List<Movie> movie;
	
	public Year() {
		
	}

	public Year(Long yearId, String yearName) {
		super();
		this.yearId = yearId;
		this.yearName = yearName;
	}
	
	public Year(String yearName) {
		super();
		this.yearName = yearName;
	}

	public Long getYearId() {
		return yearId;
	}

	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Year [yearId=" + yearId + ", yearName=" + yearName + "]";
	}
}
