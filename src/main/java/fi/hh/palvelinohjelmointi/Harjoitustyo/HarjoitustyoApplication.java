package fi.hh.palvelinohjelmointi.Harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Actor;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.ActorRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Genre;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.GenreRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Movie;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieReview;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieReviewRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Stars;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.StarsRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.User;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.UserRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Year;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.YearRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner harjoitustyoDemo(MovieReviewRepository mrrepository, StarsRepository srepository, GenreRepository grepository, YearRepository yrepository, ActorRepository arepository, MovieRepository mrepository, UserRepository urepository) {
		return (args) -> {
	
			log.info("Add movie stuff to properties and save em!");
			arepository.save(new Actor("Tom Hanks"));
			arepository.save(new Actor("Elizabeth Gillies"));
			arepository.save(new Actor("Nathalie Kelley"));
			arepository.save(new Actor("James Mackay"));
			yrepository.save(new Year("2015"));
			yrepository.save(new Year("2016"));
			yrepository.save(new Year("2017"));
			yrepository.save(new Year("2018"));
			grepository.save(new Genre("Scifi"));
			grepository.save(new Genre("Comedy"));
			grepository.save(new Genre("Drama"));
			grepository.save(new Genre("Action"));
			srepository.save(new Stars("0 / 5 tähteä"));
			srepository.save(new Stars("0,5 / 5 tähteä"));
			srepository.save(new Stars("1 / 5 tähteä"));
			srepository.save(new Stars("1,5 / 5 tähteä"));
			srepository.save(new Stars("2 / 5 tähteä"));
			mrrepository.save(new MovieReview("Review of Lentävät Alukset", "Todella hyvä räiskintä elokuva avaruusgalakseissa, jossa Tom Hanks näyttelee pääosaa."));
			mrepository.save(new Movie("Avaruus seikkailu", "1:48h", "http://esimerkki.fi", mrrepository.save(new MovieReview("Avaruus seikkailun review", "Todella hyvä sci-fi elokuva vailla vertaansa.")), srepository.save(new Stars("4,5 / 5 tähteä")), yrepository.save(new Year("2000")), arepository.save(new Actor("Esimerkki näyttelijä")), grepository.save(new Genre("Esimerkki Genre"))));
			mrepository.save(new Movie("Ready Player One", "2:20h", "http://www.imdb.com/title/tt1677720/?ref_=inth_ov_tt", mrrepository.save(new MovieReview("Ready player one review", "Sci-fi elokuva, joka kertoo virtuaalimaailmasta.")), srepository.save(new Stars("5 / 5 tähteä")), yrepository.findByYearName("2018").get(0), arepository.save(new Actor("Ben Mendelsohn")), grepository.save(new Genre("Sci-fi & Action"))));
			mrepository.save(new Movie("Tyler Perry's Acrimony", "---", "http://www.imdb.com/title/tt6063050/?ref_=inth_ov_tt", mrrepository.save(new MovieReview("TPA review", "Tulossa...")), srepository.save(new Stars("---")), yrepository.findByYearName("2018").get(0), arepository.save(new Actor("Taraji P. Henson")), grepository.findByGenreName("Action").get(0)));
			mrepository.save(new Movie("Tyler Perry's Acrimony", "---", "http://www.imdb.com/title/tt6063050/?ref_=inth_ov_tt", mrrepository.findByReviewName("TPA review").get(0), srepository.findByStarName("---").get(0), yrepository.findByYearName("2018").get(0), arepository.save(new Actor("Taraji P. Henson")), grepository.findByGenreName("Action").get(0)));
			mrepository.save(new Movie("Tyler Perry's Acrimony", "---", "http://www.imdb.com/title/tt6063050/?ref_=inth_ov_tt", mrrepository.findByReviewName("TPA review").get(0), srepository.findByStarName("---").get(0), yrepository.findByYearName("2018").get(0), arepository.save(new Actor("Taraji P. Henson")), grepository.findByGenreName("Action").get(0)));
			mrepository.save(new Movie("Tyler Perry's Acrimony", "---", "http://www.imdb.com/title/tt6063050/?ref_=inth_ov_tt", mrrepository.findByReviewName("TPA review").get(0), srepository.findByStarName("---").get(0), yrepository.findByYearName("2018").get(0), arepository.save(new Actor("Taraji P. Henson")), grepository.findByGenreName("Action").get(0)));
			
			User user1 = new User("admin", "$2a$06$QP8rFStipiTPSRNF38e1iuVrLbSINgUkEkU7ZZbQV6lwxd0CdRgAS", "ADMIN", "admin@palvelinohjelmointi.fi");
			urepository.save(user1);
			
			log.info("Fetch everything from movies");
			for (Movie movie : mrepository.findAll()) {
				log.info(movie.toString());
			}

		};
	}
}
