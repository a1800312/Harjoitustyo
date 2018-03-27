package fi.hh.palvelinohjelmointi.Harjoitustyo.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Actor;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.ActorRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Genre;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.GenreRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Movie;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieReview;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.MovieReviewRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.StarsRepository;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.Year;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.YearRepository;

@Controller
public class HarjoitustyoController {
	
	@Autowired
	private MovieRepository mrepository;
	
	@Autowired
	private MovieReviewRepository mrrepository;
	
	@Autowired
	private StarsRepository srepository;
	
	@Autowired
	private GenreRepository grepository;
	
	@Autowired
	private YearRepository yrepository;
	
	@Autowired
	private ActorRepository arepository;
	
	// kävijöille tarkoitetut sivut
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public String moviesListed(Model model) {
		model.addAttribute("movies", mrepository.findAll());
		return "/movies";
	}
	
	// toinen näkymä elokuville
	
	@RequestMapping(value="/movies2", method=RequestMethod.GET)
	public String movies2Listed(Model model) {
		model.addAttribute("movies", mrepository.findAll());
		return "/movies2";
	}
	
	//admin toiminnot tästä alas päin
	
	@RequestMapping(value="/login")
    public String login() {	
        return "/login";
    }
	
	// elokuvien muokkaus sivujen toiminnot
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/adminpagemovies", method=RequestMethod.GET)
	public String moviesListedAsAdmin(Model model) {
		model.addAttribute("movies", mrepository.findAll());
		return "/adminpagemovies";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addmovie")
	public String newMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("moviereviews", mrrepository.findAll());
		model.addAttribute("starss", srepository.findAll());
		model.addAttribute("years", yrepository.findAll());
		model.addAttribute("actors", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		return "adminaddmovie";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/savemovie", method=RequestMethod.POST)
	public String saveMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingresult, Model model){
		if (bindingresult.hasErrors()) {
			model.addAttribute("movie", new Movie());
			model.addAttribute("moviereviews", mrrepository.findAll());
			model.addAttribute("starss", srepository.findAll());
			model.addAttribute("years", yrepository.findAll());
			model.addAttribute("actors", arepository.findAll());
			model.addAttribute("genres", grepository.findAll());
			return "adminaddmovie";
		}
		mrepository.save(movie);
		return "redirect:/adminpagemovies";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/editmovie/{movieId}", method=RequestMethod.GET)
	public String editMovie(@PathVariable("movieId") Long movieId, Model model) {
		model.addAttribute("movie", mrepository.findById(movieId));
		model.addAttribute("moviereviews", mrrepository.findAll());
		model.addAttribute("starss", srepository.findAll());
		model.addAttribute("years", yrepository.findAll());
		model.addAttribute("actors", arepository.findAll());
		model.addAttribute("genres", grepository.findAll());
		return "admineditmovie";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/deletemovie/{movieId}", method=RequestMethod.GET)
	public String deleteMovie(@PathVariable("movieId") Long movieId){
		mrepository.deleteById(movieId);
		return "redirect:/adminpagemovies";
	}
	
	// takaisin navigointi nappi
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/back", method=RequestMethod.GET)
	public String backToAdminpage(Model model) {
		model.addAttribute("movies", mrepository.findAll());
		return "adminpagemovies";
	}
	
	// review movies toiminnot

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addmoviereview")
	public String newMovieReview(Model model){
		model.addAttribute("moviereview", new MovieReview());
		return "addnewmoviereview";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/savemoviereview", method=RequestMethod.POST)
	public String saveMovieReview(@Valid @ModelAttribute("moviereview") MovieReview moviereview, BindingResult bindingresult){
		if (bindingresult.hasErrors()) {
			return "addnewmoviereview";
		}
		mrrepository.save(moviereview);
		return "redirect:/adminpagemovies";
	}
	
	// actor toiminnot
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addactor")
	public String newActor(Model model){
		model.addAttribute("actor", new Actor());
		return "addnewactor";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/saveactor", method=RequestMethod.POST)
	public String saveActor(@Valid @ModelAttribute("actor") Actor actor, BindingResult bindingresult){
		if (bindingresult.hasErrors()) {
			return "addnewactor";
		}
		arepository.save(actor);
		return "redirect:/adminpagemovies";
	}
	
	// genre toiminnot
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addgenre")
	public String newGenre(Model model){
		model.addAttribute("genre", new Genre());
		return "addnewgenre";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/savegenre", method=RequestMethod.POST)
	public String saveGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult bindingresult){
		if (bindingresult.hasErrors()) {
			return "addnewgenre";
		}
		grepository.save(genre);
		return "redirect:/adminpagemovies";
	}
	
	// year toiminnot
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/addyear")
	public String newYear(Model model){
		model.addAttribute("year", new Year());
		return "addnewyear";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/saveyear", method=RequestMethod.POST)
	public String saveYear(@Valid @ModelAttribute("year") Year year, BindingResult bindingresult){
		if (bindingresult.hasErrors()) {
			return "addnewyear";
		}
		yrepository.save(year);
		return "redirect:/adminpagemovies";
	}
	
	// REST-osio tästä alaspäin
	
	// kävijöiden toiminnot
	
	@RequestMapping(value="/moviesREST", method = RequestMethod.GET)
	public @ResponseBody List<Movie> movieListRest() {
		return (List<Movie>) mrepository.findAll();
	}
	
	@RequestMapping(value="/moviesREST/{movieName}", method = RequestMethod.GET)
	public @ResponseBody List<Movie> findMoviebyNameRest(@PathVariable("movieName") String movieName) {
		return (List<Movie>) mrepository.findByMovieName(movieName);
	}
	
	@RequestMapping(value="/moviesREST/year/{yearName}", method = RequestMethod.GET)
	public @ResponseBody List<Movie> findMoviebyYearRest(@PathVariable("yearName") String yearName) {
		return (List<Movie>) yrepository.findByYearName(yearName).get(0).getMovie();
	}
}
