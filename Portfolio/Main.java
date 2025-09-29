package Portfolio;

import java.lang.classfile.Label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;   // CheckBox, Label, PasswordField, TextField, RadioButton
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * GUI for the Fitness Tracker portfolio project.
 * CheckBox, RadioButton, PasswordField, and a simple interaction with User/Goal classes.
 */
public class Main extends Application {

    private User demoUser;

    @Override
    public void start(Stage primaryStage) {
        demoUser = new User("Q", 23, 75.0, 175.0); // placeholder model

        // Controls
        Label nameLabel = new Label("User Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter a password (not saved yet)");

        Label goalLabel = new Label("Set a Goal:");
        TextField goalField = new TextField();
        goalField.setPromptText("e.g., Lose 5 kg");

        CheckBox newsletterCheck = new CheckBox("Subscribe to email updates");
        newsletterCheck.setSelected(true);

        // RadioButtons for gender example
        Label genderLabel = new Label("Gender:");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);

        Button addGoalBtn = new Button("Create Account & Add Goal");
        Label feedbackLabel = new Label();

        //Interaction
        addGoalBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String goalText = goalField.getText().trim();
            String password = passwordField.getText().trim();
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            String gender = selectedGender != null ? selectedGender.getText() : "Not specified";

            if (!name.isEmpty() && !goalText.isEmpty() && !password.isEmpty()) {
                demoUser.setName(name);
                Goal newGoal = new Goal(goalText);
                demoUser.getGoals().add(newGoal);

                feedbackLabel.setText("Welcome, " + demoUser.getName()
                        + " (" + gender + ")! Goal added: " + newGoal.getDescription()
                        + (newsletterCheck.isSelected() ? "\nYou are subscribed to updates." : "\nNo email subscription."));
                
                nameField.clear();
                goalField.clear();
                passwordField.clear();
                genderGroup.selectToggle(null);
                newsletterCheck.setSelected(true);
            } else {
                feedbackLabel.setText("Please fill in all fields before continuing.");
            }
        });

        // Layout
        VBox root = new VBox(12);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
                nameLabel, nameField,
                passLabel, passwordField,
                goalLabel, goalField,
                newsletterCheck,
                genderLabel, male, female, other,
                addGoalBtn,
                feedbackLabel
        );

        Scene scene = new Scene(root, 420, 400);
        primaryStage.setTitle("Fitness Tracker - Enhanced GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}