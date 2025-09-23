package Portfolio;
public class ExerciseTrack {
    private String name;     // e.g., Push-up, Squat, Running
    private int sets;
    private int reps;
    private double duration; // in minutes (for cardio)


    public ExerciseTrack(String name, int sets, int reps, double duration) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
    }


    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }


    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }


    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }


    // Methods
    public void logPerformance() {}
}
