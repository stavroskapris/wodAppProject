package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Athlete;
import springdemo.entity.Gender;
import springdemo.entity.RandomWorkouts;

@Repository
public class AthleteDAOImpl implements AthleteDAO {

	// need to inject the session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Athlete> getAthletes() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Athlete> theQuery = currentSession.createQuery("from Athlete", Athlete.class);
		// execute query and get result list
		List<Athlete> athletes = theQuery.getResultList();
		// return the results
		return athletes;
	}

	@Override
	public void saveAthlete(Athlete athlete) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(athlete);
	}

	@Override
	public boolean checkAthlete(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Athlete where userName = :userName");
		query.setParameter("userName", userName);
		List<Athlete> athlete = query.getResultList();
		return (athlete.size() != 0);
	}

	@Override
	public Athlete getAthlete(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Athlete where userName = :userName");
		query.setParameter("userName", userName);
		List<Athlete> athlete = query.getResultList();
		return athlete.get(0);
	}

	@Override
	public void addFavWorkout(int workoutId, String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query1 = currentSession.createQuery("from Athlete where userName = :userName");
		query1.setParameter("userName", userName);
		List<Athlete> athletes = query1.getResultList();
		Athlete athlete = athletes.get(0);
		Query query2 = currentSession.createQuery("from RandomWorkouts where id = :workoutId");
		query2.setParameter("workoutId", workoutId);
		List<RandomWorkouts> randomWorkouts = query2.getResultList();
		RandomWorkouts workout = randomWorkouts.get(0);
		athlete.addWorkout(workout);
	}

	@Override
	public void deleteFavWorkout(int workoutId, String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query1 = currentSession.createQuery("from Athlete where userName = :userName");
		query1.setParameter("userName", userName);
		List<Athlete> athletes = query1.getResultList();
		Athlete athlete = athletes.get(0);
		Query query2 = currentSession.createQuery("from RandomWorkouts where id = :workoutId");
		query2.setParameter("workoutId", workoutId);
		List<RandomWorkouts> randomWorkouts = query2.getResultList();
		RandomWorkouts workout = randomWorkouts.get(0);
		athlete.deleteWorkout(workout);
	}

	@Override
	public Athlete getAthleteById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Athlete athlete = currentSession.get(Athlete.class, theId);
		return athlete;
	}

	@Override
	public void updateAthlete(String userName, String firstName, String lastName, int theId, Gender gender) {
		Session currentSession = sessionFactory.getCurrentSession();
		Athlete athlete = currentSession.get(Athlete.class, theId);
		athlete.setFirstName(firstName);
		athlete.setLastName(lastName);
		athlete.setUserName(userName);
		athlete.setGender(gender);

	}
}
