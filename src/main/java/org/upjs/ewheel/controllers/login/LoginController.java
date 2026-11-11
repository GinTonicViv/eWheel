package org.upjs.ewheel.controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.upjs.ewheel.controllers.mainPage.MainPageController;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButotn;

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        // TODO: validacia prihlasenia

        // jeden Stage: len vymenime scenu, takze nie je co zatvarat
        Stage stage = (Stage) loginButotn.getScene().getWindow();

        var loader = new FXMLLoader(getClass().getResource("/org/upjs/ewheel/view/mainPage.fxml"));
        Parent rootPane = loader.load();
        MainPageController mainController = loader.getController(); // hlavny kontroler appky
        mainController.showDashboard();

        stage.setScene(new Scene(rootPane));
        stage.setMaximized(true);
    }
}
