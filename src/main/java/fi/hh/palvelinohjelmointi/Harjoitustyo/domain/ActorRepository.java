package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {

	List<Actor> findByActorName(String actorName);

}
