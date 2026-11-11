package org.upjs.ewheel.controllers.mainPage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    public void showDashboard() {
        setContent("dashboard.fxml");
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
