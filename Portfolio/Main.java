package Portfolio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;

/**
 * Track B – Business Logic Integration
 *
 * This GUI connects directly to the project's model classes.
 * Features:
 *  • Create/update a user profile (name, weight, height)
 *  • Auto-calculate and display BMI
 *  • Add and remove goals dynamically (stored in the User object)
 *  • Live ListView feedback for all goals
 */
public class Main extends Application {

    private User demoUser;
    private ObservableList<String> goalListData;

    @Override
    public void start(Stage primaryStage) {
        // ===== Model & Observable Setup =====
        demoUser = new User("Q", 23, 75.0, 175.0);
        goalListData = FXCollections.observableArrayList();

        // ===== User Info Section =====
        Label nameLabel = new Label("User Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Label weightLabel = new Label("Weight (kg):");
        TextField weightField = new TextField();
        weightField.setPromptText("e.g., 75.0");

        Label heightLabel = new Label("Height (cm):");
        TextField heightField = new TextField();
        heightField.setPromptText("e.g., 175.0");

        Button createUserBtn = new Button("Create/Update User");

        // Label that displays BMI result
        Label bmiLabel = new Label("BMI: —");

        // ===== Goal Input Section =====
        Label goalLabel = new Label("Add a New Goal:");
        TextField goalField = new TextField();
        goalField.setPromptText("e.g., Run 10K in under 1 hour");
        Button addGoalBtn = new Button("Add Goal");

        // ===== Goal Display Section =====
        Label goalsTitle = new Label("Your Goals:");
        ListView<String> goalListView = new ListView<>(goalListData);
        goalListView.setPrefHeight(150);
        Button removeGoalBtn = new Button("Remove Selected Goal");

        Label feedbackLabel = new Label();

        // ===== Logic: Create/Update User + BMI =====
        createUserBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String weightText = weightField.getText().trim();
            String heightText = heightField.getText().trim();

            try {
                if (!name.isEmpty() && !weightText.isEmpty() && !heightText.isEmpty()) {
                    demoUser.setName(name);
                    demoUser.setWeight(Double.parseDouble(weightText));
                    demoUser.setHeight(Double.parseDouble(heightText));

                    // Calculate BMI
                    double heightM = demoUser.getHeight() / 100.0;
                    double bmi = demoUser.getWeight() / (heightM * heightM);
                    bmiLabel.setText(String.format("BMI: %.2f", bmi));

                    feedbackLabel.setText("User updated: " + demoUser.getName()
                            + " (" + demoUser.getWeight() + "kg, " + demoUser.getHeight() + "cm)");
                } else {
                    feedbackLabel.setText("Please fill in all user fields.");
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Weight and height must be numeric.");
            }
        });

        // ===== Logic: Add New Goal =====
        addGoalBtn.setOnAction(e -> {
            String goalText = goalField.getText().trim();
            if (!goalText.isEmpty()) {
                Goal newGoal = new Goal(goalText);
                demoUser.addGoal(newGoal); // Connect to model
                goalListData.add(newGoal.getDescription());
                goalField.clear();
                feedbackLabel.setText("Goal added successfully!");
            } else {
                feedbackLabel.setText("Please enter a goal description.");
            }
        });

        // ===== Logic: Remove Selected Goal =====
        removeGoalBtn.setOnAction(e -> {
            String selected = goalListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                // Remove from both ListView and model
                goalListData.remove(selected);
                demoUser.getGoals().removeIf(g -> g.getDescription().equals(selected));
                feedbackLabel.setText("Goal removed: " + selected);
            } else {
                feedbackLabel.setText("Please select a goal to remove.");
            }
        });

        // ===== Layout Organization =====
        VBox userBox = new VBox(6, nameLabel, nameField, weightLabel, weightField,
                                heightLabel, heightField, createUserBtn, bmiLabel);
        userBox.setPadding(new Insets(10));
        userBox.setStyle("-fx-border-color: lightgray; -fx-border-width: 1; -fx-border-radius: 4;");

        VBox goalBox = new VBox(6, goalLabel, goalField, addGoalBtn);
        goalBox.setPadding(new Insets(10));
        goalBox.setStyle("-fx-border-color: lightgray; -fx-border-width: 1; -fx-border-radius: 4;");

        VBox displayBox = new VBox(8, goalsTitle, goalListView, removeGoalBtn, feedbackLabel);
        displayBox.setPadding(new Insets(10));

        VBox root = new VBox(12, userBox, goalBox, displayBox);
        root.setPadding(new Insets(20));

        // ===== Stage Setup =====
        Scene scene = new Scene(root, 460, 550);
        primaryStage.setTitle("Fitness Tracker - Logic Integration + Enhancements");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
