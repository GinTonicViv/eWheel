package org.upjs.ewheel.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;

public class LoginController {

    @FXML
    private Button loginButotn;

    private Stage loginSatge;

    @FXML
    public void initialize(Stage loginSatge) {
        this.loginSatge = loginSatge;
    }

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        System.out.println("Login button event");
    }

    @FXML
    void loginPressed() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("/org/upjs/ewheel/view/dashboardMain.fxml"));
        Parent rootPane = loader.load();

        var scene = new Scene(rootPane);

        Stage stage = new Stage();
        stage.setMaximized(false);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        //nastavenie fillnutia screenu
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getMaxX());
        stage.setHeight(bounds.getMaxY());

        stage.setTitle("eWheel");
        stage.setScene(scene);
        stage.show();
        //uz po validacii mozeme zavriet login okno
        loginSatge.close();
    }

}
