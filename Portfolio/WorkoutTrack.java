package Portfolio;
import java.util.ArrayList;
import java.time.LocalDate;


public class WorkoutTrack {
    private LocalDate date;
    private String type; // e.g., Cardio, Strength, Flexibility
    private ArrayList<ExerciseTrack> exercises;


    public WorkoutTrack(LocalDate date, String type) {
        this.date = date;
        this.type = type;
        this.exercises = new ArrayList<>();
    }


    // Getters & Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }


    public String getType() { return type; }
    public void setType(String type) { this.type = type; }


    public ArrayList<ExerciseTrack> getExercises() { return exercises; }


    // Methods
    public void addExercise(ExerciseTrack exercise) {}
    public void removeExercise(ExerciseTrack exercise) {}
}
