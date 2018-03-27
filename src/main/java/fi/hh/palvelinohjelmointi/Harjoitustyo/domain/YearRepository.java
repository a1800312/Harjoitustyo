package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface YearRepository extends CrudRepository<Year, Long> {

	List<Year> findByYearName(String yearName);

}
