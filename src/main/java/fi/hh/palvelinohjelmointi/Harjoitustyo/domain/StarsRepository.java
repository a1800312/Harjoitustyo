package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StarsRepository extends CrudRepository<Stars, Long> {

	List<Stars> findByStarName(String starName);

}
