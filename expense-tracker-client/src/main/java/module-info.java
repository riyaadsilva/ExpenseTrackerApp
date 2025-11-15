module expense.tracker.client {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires com.google.gson;

    exports org.example;
    opens org.example.controllers to javafx.fxml;
    opens org.example.views to javafx.fxml;

    // FIX for TableView reflection access
    opens org.example.models to javafx.base;
}