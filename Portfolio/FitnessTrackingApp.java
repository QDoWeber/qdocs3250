package Portfolio;
import java.util.ArrayList;


public class FitnessTrackingApp {
    private ArrayList<User> users;


    public FitnessTrackingApp() {
        this.users = new ArrayList<>();
    }


    public ArrayList<User> getUsers() { return users; }


    // Methods
    public void registerUser(User user) {}
    public void showUserProgress(User user) {}
}

