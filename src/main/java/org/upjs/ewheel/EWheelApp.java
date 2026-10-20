package org.upjs.ewheel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.upjs.ewheel.dashboard.DashBoardController;

public class EWheelApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var loader = new FXMLLoader(getClass().getResource("/org/upjs/ewheel/view/dashboardMain.fxml"));
        Parent rootPane = loader.load();

        var scene = new Scene(rootPane);
        primaryStage.setTitle("eWheel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
