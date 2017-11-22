package springdemo.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Athlete;
import springdemo.entity.RandomWorkouts;

@Repository
public class RandomWorkoutsDAOImpl implements RandomWorkoutsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public RandomWorkouts getWorkout() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<RandomWorkouts> theQuery = currentSession.createQuery("from RandomWorkouts", RandomWorkouts.class);
		List<RandomWorkouts> randomWorkoutsList = theQuery.getResultList();
		Random randomGenerator;
		randomGenerator = new Random();
		int index = randomGenerator.nextInt(randomWorkoutsList.size());
		return randomWorkoutsList.get(index);
	}

	@Override
	public List<RandomWorkouts> getFavourites(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query1 = currentSession.createQuery("from Athlete where userName = :userName");
		query1.setParameter("userName", userName);
		List<Athlete> athletes = query1.getResultList();
		Athlete athlete = athletes.get(0);
		List<RandomWorkouts> athletesFavourites = athlete.getWorkouts();
		return athletesFavourites;
	}
}
