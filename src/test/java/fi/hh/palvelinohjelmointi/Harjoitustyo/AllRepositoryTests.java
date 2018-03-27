package fi.hh.palvelinohjelmointi.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Year;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.YearRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AllRepositoryTests {
	@Autowired
	private MovieRepository mrepository;
	
	@Autowired
	private MovieReviewRepository mrrepository;
	
	@Autowired
	private StarsRepository srepository;
	
	@Autowired
	private ActorRepository arepository;
	
	@Autowired
	private YearRepository yrepository;
	
	@Autowired
	private GenreRepository grepository;
	
	// movie tests
	
	@Test
	public void findByTitleShouldReturnMovie() {
		List<Movie> movies = mrepository.findByMovieName("Avaruus seikkailu");
		assertThat(movies).hasSize(1);
		assertThat(movies.get(0).getMovieName()).isEqualTo("Avaruus seikkailu");
	}
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("Ready Player One", "2:20", "http://www.imdb.com/title/tt1677720/?ref_=inth_ov_tt", mrrepository.save(new MovieReview("Ready player one review", "Todella hyvä sci-fi elokuva vailla vertaansa, joka perustuu virtuaalimaailmaan.")), srepository.save(new Stars("6 tähteä ja papukaija merkki")), yrepository.save(new Year("2022")), arepository.save(new Actor("Lena Waithe")), grepository.save(new Genre("Action")));
		mrepository.save(movie);
		assertThat(movie.getMovieId()).isNotNull();
		assertThat(movie.getMovieName()).isNotEmpty();
		assertThat(movie.getMovieLength()).isNotEmpty();
		assertThat(movie.getMovieIMDBURL()).isNotEmpty();
		assertThat(movie.getMoviereview()).isNotNull();
		assertThat(movie.getStars()).isNotNull();
		assertThat(movie.getYear()).isNotNull();
		assertThat(movie.getActor()).isNotNull();
		assertThat(movie.getGenre()).isNotNull();
	}
	
	@Test
	public void deleteMovie() {
		List<Movie> movies = mrepository.findByMovieName("Avaruus seikkailu");
		mrepository.deleteAll(movies);
		List<Movie> moviesD = mrepository.findByMovieName("Avaruus seikkailu");
		assertThat(moviesD.get(0).getMovieId()).isNull();
		assertThat(moviesD.get(0).getMovieId()).isNull();
		assertThat(moviesD.get(0).getMovieName()).isEmpty();
		assertThat(moviesD.get(0).getMovieLength()).isEmpty();
		assertThat(moviesD.get(0).getMovieIMDBURL()).isEmpty();
		assertThat(moviesD.get(0).getMoviereview()).isNull();
		assertThat(moviesD.get(0).getStars()).isNull();
		assertThat(moviesD.get(0).getYear()).isNull();
		assertThat(moviesD.get(0).getActor()).isNull();
		assertThat(moviesD.get(0).getGenre()).isNull();
	}
	
	// actor tests
	
	@Test
	public void findByActorNameShouldReturnActor() {
		List<Actor> actors = arepository.findByActorName("Tom Hanks");
		assertThat(actors).hasSize(1);
		assertThat(actors.get(0).getActorName()).isEqualTo("Tom Hanks");
	}
	
	@Test
	public void createNewActor() {
		Actor actor = new Actor("Olivia Cooke");
		arepository.save(actor);
		assertThat(actor.getActorId()).isNotNull();
		assertThat(actor.getActorName()).isNotEmpty();
	}
	
	@Test
	public void deleteActor() {
		List<Actor> actors = arepository.findByActorName("Esimerkki näyttelijä");
		arepository.deleteAll(actors);
		List<Actor> actorsD = arepository.findByActorName("Esimerkki näyttelijä");
		assertThat(actorsD.get(0).getActorId()).isNull();
		assertThat(actorsD.get(0).getActorName()).isEmpty();
	}
	
	// genre tests
	
	@Test
	public void findByGenreNameShouldReturnGenre() {
		List<Genre> genres = grepository.findByGenreName("Esimerkki Genre");
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getGenreName()).isEqualTo("Esimerkki Genre");
	}
	
	@Test
	public void createNewGenre() {
		Genre genre = new Genre("Love-story");
		grepository.save(genre);
		assertThat(genre.getGenreId()).isNotNull();
		assertThat(genre.getGenreName()).isNotEmpty();
	}
	
	@Test
	public void deleteGenre() {
		List<Genre> genres = grepository.findByGenreName("Esimerkki Genre");
		grepository.deleteAll(genres);
		List<Genre> genresD = grepository.findByGenreName("Esimerkki Genre");
		assertThat(genresD.get(0).getGenreId()).isNull();
		assertThat(genresD.get(0).getGenreName()).isEmpty();
	}
	
	// movie review tests
	
	@Test
	public void findByMovieReviewNameShouldReturnMovieReview() {
		List<MovieReview> moviereviews = mrrepository.findByReviewName("Avaruus seikkailun review");
		assertThat(moviereviews).hasSize(1);
		assertThat(moviereviews.get(0).getReviewName()).isEqualTo("Avaruus seikkailun review");
	}
	
	@Test
	public void createNewMovieReview() {
		MovieReview moviereview = new MovieReview("Esimerkki review uusi", "Bla bla bla bla blaaa");
		mrrepository.save(moviereview);
		assertThat(moviereview.getMovieReviewId()).isNotNull();
		assertThat(moviereview.getReviewName()).isNotEmpty();
		assertThat(moviereview.getReviewText()).isNotEmpty();
	}
	
	@Test
	public void deleteMovieReview() {
		List<MovieReview> moviereviews = mrrepository.findByReviewName("Avaruus seikkailun review");
		mrrepository.deleteAll(moviereviews);
		List<MovieReview> moviereviewsD = mrrepository.findByReviewName("Avaruus seikkailun review");
		assertThat(moviereviewsD.get(0).getMovieReviewId()).isNull();
		assertThat(moviereviewsD.get(0).getReviewName()).isEmpty();
		assertThat(moviereviewsD.get(0).getReviewText()).isEmpty();
	}
	
	// movie stars tests
	
		@Test
		public void findByStarNameShouldReturnStar() {
			List<Stars> starss = srepository.findByStarName("6 tähteä");
			assertThat(starss).hasSize(1);
			assertThat(starss.get(0).getStarName()).isEqualTo("6 tähteä");
		}
		
		@Test
		public void createNewStarRating() {
			Stars stars = new Stars("10/10 tähteä + papukaijamerkki!");
			srepository.save(stars);
			assertThat(stars.getStarId()).isNotNull();
			assertThat(stars.getStarName()).isNotEmpty();
		}
		
		@Test
		public void deleteStarRating() {
			List<Stars> stars = srepository.findByStarName("6 tähteä");
			srepository.deleteAll(stars);
			List<Stars> starsD = srepository.findByStarName("6 tähteä");
			assertThat(starsD.get(0).getStarId()).isNull();
			assertThat(starsD.get(0).getStarName()).isEmpty();
		}
		
		// movie year tests
		
			@Test
			public void findByYearNameShouldReturnYear() {
				List<Year> years = yrepository.findByYearName("2000");
				assertThat(years).hasSize(1);
				assertThat(years.get(0).getYearName()).isEqualTo("2000");
			}
			
			@Test
			public void createNewLabelForYear() {
				Year year = new Year("1989");
				yrepository.save(year);
				assertThat(year.getYearId()).isNotNull();
				assertThat(year.getYearName()).isNotEmpty();
			}
			
			@Test
			public void deleteLabelFromYear() {
				List<Year> years = yrepository.findByYearName("2000");
				yrepository.deleteAll(years);
				List<Year> yearsD = yrepository.findByYearName("2000");
				assertThat(yearsD.get(0).getYearId()).isNull();
				assertThat(yearsD.get(0).getYearName()).isEmpty();
			}
}
