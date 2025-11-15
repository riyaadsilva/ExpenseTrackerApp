package org.example;

import org.example.utils.ViewNavigator;
import org.example.views.LoginView;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Expense Tracker");
        ViewNavigator.setMainStage(stage);
        new LoginView().show();
    }

    // ADD THIS MAIN METHOD
    public static void main(String[] args) {
        launch(args);
    }
}
