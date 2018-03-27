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
public class Stars {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long starId;
	
	@NotNull
	@Size(min=1, max=100)
	private String starName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="stars")
	private List<Movie> movie;
	
	public Stars () {
		
	}

	public Stars(Long starId, String starName) {
		super();
		this.starId = starId;
		this.starName = starName;
	}
	
	public Stars(String starName) {
		super();
		this.starName = starName;
	}

	public Long getStarId() {
		return starId;
	}

	public void setStarId(Long starId) {
		this.starId = starId;
	}

	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
	}

	@Override
	public String toString() {
		return "Stars [starId=" + starId + ", starName=" + starName + "]";
	}
}
