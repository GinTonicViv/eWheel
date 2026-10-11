package org.upjs.ewheel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.upjs.ewheel.Dashboard.DashBoardController;

public class EWheelApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        var fxmlLoader = new FXMLLoader(
                getClass().getResource("AttenderApp.fxml")
        );

        var mainController = new DashBoardController();
        fxmlLoader.setController(mainController);
        Parent rootPane = fxmlLoader.load();
        var scene = new Scene(rootPane);
        primaryStage.setTitle("Dochádzky");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
