package springdemo.service;

import java.util.List;

import springdemo.entity.RandomWorkouts;

public interface RandomWorkoutsService {
	
	
	public RandomWorkouts getWorkout();

	public List<RandomWorkouts> getFavourites(String userName);


}
