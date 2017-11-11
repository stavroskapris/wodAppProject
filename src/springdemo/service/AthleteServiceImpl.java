package springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.AthleteDAO;
import springdemo.entity.Athlete;
import springdemo.entity.Gender;

@Service
public class AthleteServiceImpl implements AthleteService {
	
	@Autowired
 private AthleteDAO athleteDAO;
 
	@Override
	@Transactional
	public List<Athlete> getAthletes() {
		
		return athleteDAO.getAthletes();
	}

	@Override
	@Transactional
	public void saveAthlete(Athlete athlete) {
		athleteDAO.saveAthlete(athlete);
	}

	@Override
	@Transactional
	public boolean checkAthlete(String userName) {
		
		return athleteDAO.checkAthlete(userName);
	}

	@Override
	@Transactional
	public void addFavWourkout(int workoutId, String userName) {
		athleteDAO.addFavWorkout(workoutId,userName);
		
	}

	@Override
	@Transactional
	public void deleteFavWourkout(int workoutId, String userName) {
	
		athleteDAO.deleteFavWorkout(workoutId,userName);
		
	}

	@Override
	@Transactional
	public Athlete getAtlete(String userName) {
		// TODO Auto-generated method stub
		return athleteDAO.getAthlete(userName);	}

	@Override
	@Transactional
	public Athlete getAthleteById(int theId) {
		// TODO Auto-generated method stub
		return athleteDAO.getAthleteById(theId);
	}

	@Override
	@Transactional
	public void updateAthlete(String userName,String firstName,String lastName,int theId,Gender gender) {
		
	athleteDAO.updateAthlete(userName,firstName,lastName,theId,gender);
	}


}
