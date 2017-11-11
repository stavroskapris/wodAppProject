package springdemo.service;

import java.util.List;

import springdemo.entity.Athlete;
import springdemo.entity.Gender;

public interface AthleteService {
	
public List<Athlete> getAthletes();

public void saveAthlete(Athlete athlete);

public boolean checkAthlete(String userName);

public void addFavWourkout(int workoutId, String userName);

public void deleteFavWourkout(int workoutId, String userName);

public Athlete getAtlete(String userName);

public Athlete getAthleteById(int theId);

public void updateAthlete(String userName,String firstName, String lastName, int theId,Gender gender);


}
