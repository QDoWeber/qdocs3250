package Portfolio;


public class Goal {
    private String description; // e.g., "Lose 5kg", "Run 10K in under 1 hour"
    private boolean achieved;


    public Goal(String description) {
        this.description = description;
        this.achieved = false;
    }
    public int EstimateTimeToReachGoal(User user){
        double dailyIntake = 0;
        double dailyBurn = 0;
   
        // Calculate averages from nutrition logs
        for (Diet log : user.getDiet()) {
            dailyIntake += log.getTotalCalories();
        }
        if (!user.getDiet().isEmpty()) {
            dailyIntake /= user.getDiet().size();
        }
   
        // Calculate averages from workouts (example: sum exercise duration * some burn rate)
        for (WorkoutTrack w : user.getWorkouts()) {
            for (ExerciseTrack e : w.getExercises()) {
                dailyBurn += e.getDuration() * 8; // placeholder 8 kcal/min
            }
        }
        if (!user.getWorkouts().isEmpty()) {
            dailyBurn /= user.getWorkouts().size();
        }
   
        double dailyDeficit = dailyBurn - dailyIntake;
   
        double caloriesNeeded = 3500 * 5; // e.g. lose ~5 lbs
        return (int)Math.ceil(caloriesNeeded / dailyDeficit);
    }
    // Getters & Setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isAchieved() { return achieved; }
    public void setAchieved(boolean achieved) { this.achieved = achieved; }


    // Methods
    public void markAsAchieved() {}
   
}

