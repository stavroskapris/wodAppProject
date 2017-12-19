package springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springdemo.entity.Athlete;
import springdemo.entity.Gender;
import springdemo.entity.RandomWorkouts;
import springdemo.service.AthleteService;
import springdemo.service.RandomWorkoutsService;

@Controller
@RequestMapping("/athlete")
public class AthleteController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Autowired
	private RandomWorkoutsService randomWorkoutsService;

	@Autowired
	private AthleteService athleteService;

	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		Athlete athlete = new Athlete();
		theModel.addAttribute("athlete", athlete);
		return "athlete-form";
	}

	@GetMapping("/login")
	public String login(Model theModel) {
		Athlete athlete = new Athlete();
		theModel.addAttribute("athlete", athlete);
		return "login";
	}

	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("athlete") Athlete athlete, BindingResult theBindingResult,
			Model theModel, @RequestParam("userName") String userName, RedirectAttributes redirectAttributes) {
		if (theBindingResult.hasErrors()) {
			return "athlete-form";
		} else {
			boolean exists = athleteService.checkAthlete(userName);
			if (exists == false) {
				athleteService.saveAthlete(athlete);
				RandomWorkouts randomWorkout = randomWorkoutsService.getWorkout();
				theModel.addAttribute("randomWorkout", randomWorkout);
				return "athlete-confirmation";
			} else {
				redirectAttributes.addFlashAttribute("message", "Your are already member please log in");
				return "redirect:/athlete/login";
			}
		}
	}

	@RequestMapping("/welcome")
	public String welcome(@ModelAttribute("athlete") Athlete athlete, Model theModel,
			@RequestParam("userName") String userName, RedirectAttributes redirectAttributes) {
		if (userName == null) {
			redirectAttributes.addFlashAttribute("message1", "is required");
			return "redirect:/athlete/login";

		}
		boolean exists = athleteService.checkAthlete(userName);
		if (exists == true) {
			athlete = athleteService.getAtlete(userName);
			RandomWorkouts randomWorkout = randomWorkoutsService.getWorkout();
			theModel.addAttribute("randomWorkout", randomWorkout);
			theModel.addAttribute("athlete", athlete);
			return "welcomeBack-form";
		} else {
			redirectAttributes.addFlashAttribute("message", "User name does not exist please sign up");
			return "redirect:/athlete/showForm";
		}
	}

	@RequestMapping("athlete/favouriteWorkouts")
	public String favouriteWorkouts(@RequestParam("userName") String userName, Model theWorkoutsModel,
			@ModelAttribute("athlete") Athlete athlete, RedirectAttributes redirectAttributes) {
		List<RandomWorkouts> favouriteList = randomWorkoutsService.getFavourites(userName);
		theWorkoutsModel.addAttribute("favouritelist", favouriteList);
		if (favouriteList.isEmpty()) {
			redirectAttributes.addFlashAttribute("message3", " Your dont have any favourites!!!");
			redirectAttributes.addAttribute("userName", userName);
			return "redirect:/athlete/welcome";
		} else {
			return "favourites";
		}
	}

	@RequestMapping("/addToFavoutites")
	public String addfavouriteWorkout(@RequestParam("workoutId") int workoutId,
			@RequestParam("userName") String userName, @ModelAttribute("athlete") Athlete athlete,
			RedirectAttributes redirectAttributes) {
		try {
			athleteService.addFavWourkout(workoutId, userName);
			redirectAttributes.addFlashAttribute("message1", " Your workout was added successfully!!!");
			redirectAttributes.addAttribute("userName", userName);
			return "redirect:/athlete/welcome";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message2", "Already Favourite ");
			redirectAttributes.addAttribute("userName", userName);
		}
		return "redirect:/athlete/welcome";
	}

	@RequestMapping("/delete")
	public String deleteFavWorkout(@RequestParam("workoutId") int workoutId, @RequestParam("userName") String userName,
			RedirectAttributes redirectAttributes) {
		athleteService.deleteFavWourkout(workoutId, userName);
		redirectAttributes.addAttribute("userName", userName);
		return "redirect:/athlete/athlete/favouriteWorkouts";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("athleteId") int theId, Model theModel) {
		// get the customer from our service
		Athlete athlete = athleteService.getAthleteById(theId);
		// set a customer as a model attribute to pre-populate the form
		theModel.addAttribute("athlete", athlete);
		return "update-form";

	}

	@PostMapping("/processUpdateForm")
	public String processUpdateForm(@Valid @ModelAttribute("athlete") Athlete athlete, BindingResult theBindingResult,
			Model theModel, @RequestParam("userName") String userName, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("update") int theId,
			@RequestParam("gender") Gender gender, RedirectAttributes redirectAttributes) {
		if (theBindingResult.hasErrors()) {
			return "update-form";
		} else {
			athleteService.updateAthlete(userName, firstName, lastName, theId, gender);
			theModel.addAttribute("athlete", athlete);
			redirectAttributes.addAttribute("userName", userName);
			return "redirect:/athlete/welcome";
		}
	}
}
