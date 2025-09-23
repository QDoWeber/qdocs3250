package Portfolio;
import java.time.LocalDate;
import java.util.HashMap;


public class Diet {
    private LocalDate date;
    private HashMap<String, Integer> foodItems; // food name → calories
    private int totalCalories;


    public Diet(LocalDate date) {
        this.date = date;
        this.foodItems = new HashMap<>();
        this.totalCalories = 0;
    }


    // Getters & Setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }


    public int getTotalCalories() { return totalCalories; }


    // Methods
    public void addFood(String food, int calories) {}
    public void removeFood(String food) {}
}
