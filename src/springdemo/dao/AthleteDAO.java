package springdemo.dao;

import java.util.List;

import springdemo.entity.Athlete;
import springdemo.entity.Gender;

public interface AthleteDAO {

	public List<Athlete> getAthletes();

	public void saveAthlete(Athlete athlete);

	public boolean checkAthlete(String userName);

	public void addFavWorkout(int workoutId, String userName);

	public void deleteFavWorkout(int workoutId, String userName);

	public Athlete getAthlete(String userName);

	public Athlete getAthleteById(int theId);

	public void updateAthlete(String userName, String firstName, String lastName, int theId, Gender gender);

}
