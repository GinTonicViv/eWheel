package org.upjs.ewheel.controllers.mainPage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import org.upjs.ewheel.DaoFactory;
import org.upjs.ewheel.trips.TripsDao;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

public class MainPageController {

    @FXML
    private StackPane contentPane;
    private final TripsDao tripsDao = DaoFactory.INSTANCE.getTripsDao();

    @FXML
    private HBox dashboardNavButton;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label sceneNameTitle;

    @FXML
    private HBox menuBar;

    @FXML
    private HBox tripAprovalNavButton;

    @FXML
    private HBox tripsBookNavButton;

    @FXML
    private ImageView userAvatarImage;

    @FXML
    private HBox vehicleAdministrationNavButton;

    public void showDashboard() {
        setContent("dashboard.fxml");
        sceneNameTitle.setText("Prehľad");
    }

    public void showVehicleAdministration() {
        setContent("vehicle-administration.fxml");
        sceneNameTitle.setText("Administrácia vozidiel");
    }

    public void showTripsBook() {
        setContent("tripsBook.fxml");
        sceneNameTitle.setText("Kniha výjazdov");
    }

    public void showTripApproval() {
        setContent("tripApprovals.fxml");
        sceneNameTitle.setText("Schvaľovanie výjazdov");
    }

    @FXML
    void showDashboard(MouseEvent event) {
        showDashboard();
    }

    @FXML
    void showTripApproval(MouseEvent event) {
        showTripApproval();
    }

    @FXML
    void showTripsBook(MouseEvent event) {
        showTripsBook();
    }

    @FXML
    void showVehicleAdministration(MouseEvent event) {
        showVehicleAdministration();
    }

    void initialize() {

    }

    public void setContent(String fxmlName) {
        try {
            Parent view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/upjs/ewheel/view/" + fxmlName)));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
