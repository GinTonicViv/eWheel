package org.upjs.ewheel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EWheelApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        var fxmlLoader = new FXMLLoader(
                getClass().getResource("AttenderApp.fxml")
        );

        var mainController = new AttenderController();
        fxmlLoader.setController(mainController);
        Parent rootPane = fxmlLoader.load();
        var scene = new Scene(rootPane);
        stage.setTitle("Dochádzky");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
