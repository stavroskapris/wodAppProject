package springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="athlete")
public class Athlete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name = "first_name")
     private String firstName;
	
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name = "last_name")
    private String lastName;
	
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	@Column(name = "user_name")
	private String userName;
	
	
	@Column(columnDefinition = "enum('M','F')")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	

	@ManyToMany(fetch=FetchType.EAGER , 
			cascade = { CascadeType.DETACH, CascadeType.MERGE,
		    CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(
			name="athlete_favourite_workouts",
			joinColumns=@JoinColumn(name="athlete_id"),
			inverseJoinColumns=@JoinColumn(name="workout_id")
			)
	private List<RandomWorkouts> workouts;
	
	public Athlete(){
		
		
		
	}




	public Athlete(String firstName, String lastName, String userName, Gender gender) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.gender = gender;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Gender getGender() {
		return gender;
	}




	public void setGender(Gender gender) {
		this.gender = gender;
	}




	public List<RandomWorkouts> getWorkouts() {
		return workouts;
	}




	public void setWorkouts(List<RandomWorkouts> workouts) {
		this.workouts = workouts;
	}

	
	//add a convenience method 
	
		public void addWorkout(RandomWorkouts workout){
			if(workouts==null){
				
				workouts = new ArrayList<>();
				
			}
			
			workouts.add(workout);
		}

		public void deleteWorkout(RandomWorkouts workout){
			
			
			workouts.remove(workout);
		}
		
		
		

	@Override
	public String toString() {
		return "Athlete [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", gender=" + gender + "]";
	}





	
	
	
	
	
	
}
