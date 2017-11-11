package springdemo.dao;

import java.util.List;

import springdemo.entity.RandomWorkouts;

public interface RandomWorkoutsDAO {
	
	public RandomWorkouts getWorkout();

	public List<RandomWorkouts> getFavourites(String userName);

}
