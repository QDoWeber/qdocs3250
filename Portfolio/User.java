package Portfolio;
import java.util.ArrayList;
public class User {
    private String name;
    private int age;
    private double weight; //in kg
    private double height; //in cm
    private ArrayList<WorkoutTrack> workouts;
    private ArrayList<Diet> diets;
    private ArrayList<Goal> goals;


    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.workouts = new ArrayList<>();
        this.diets = new ArrayList<>();
        this.goals = new ArrayList<>();
    }
   // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }


    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }




    public ArrayList<WorkoutTrack> getWorkouts() { return workouts; }
    public ArrayList<Diet> getDiet() { return diets; }
    public ArrayList<Goal> getGoals() { return goals; }


    // Methods
    public void addWorkout(WorkoutTrack workout) {}
    public void addNutritionLog(Diet diet) {}
    public void addGoal(Goal goal) {}
}
