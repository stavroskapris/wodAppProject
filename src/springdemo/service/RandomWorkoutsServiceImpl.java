package springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.RandomWorkoutsDAO;
import springdemo.entity.RandomWorkouts;

@Service
public class RandomWorkoutsServiceImpl implements RandomWorkoutsService {

	@Autowired
	private RandomWorkoutsDAO randomWorkoutsDAO;

	@Override
	@Transactional
	public RandomWorkouts getWorkout() {
		return randomWorkoutsDAO.getWorkout();
	}

	@Override
	@Transactional
	public List<RandomWorkouts> getFavourites(String userName) {
		return randomWorkoutsDAO.getFavourites(userName);
	}
}
