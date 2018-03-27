package fi.hh.palvelinohjelmointi.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieReviewRepository extends CrudRepository<MovieReview, Long> {

	List<MovieReview> findByReviewName(String reviewName);

}
