package springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "random_workouts")
public class RandomWorkouts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "athlete_favourite_workouts", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "athlete_id")

	)
	private List<Athlete> athletes;

	public RandomWorkouts() {

	}

	public RandomWorkouts(String title) {

		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}

	public void setAthletes(List<Athlete> athletes) {
		this.athletes = athletes;
	}

	// add a convenience method
	public void addAthlete(Athlete theAthlete) {
		if (athletes == null) {
			athletes = new ArrayList<>();
		}
		athletes.add(theAthlete);
	}

	@Override
	public String toString() {
		return title;
	}
}
