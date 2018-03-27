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
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long actorId;
	
	@NotNull
	@Size(min=1, max=255)
	private String actorName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="actor")
	private List<Movie> movie;
	
	public Actor() {
		
	}

	public Actor(Long actorId, String actorName) {
		super();
		this.actorId = actorId;
		this.actorName = actorName;
	}
	
	public Actor(String actorName) {
		super();
		this.actorName = actorName;
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", movie=" + movie + "]";
	}
}
