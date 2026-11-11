package org.upjs.ewheel.controllers.dashboard;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import org.upjs.ewheel.DaoFactory;
import org.upjs.ewheel.trips.Trip;
import org.upjs.ewheel.trips.TripsDao;
import org.upjs.ewheel.vehicles.Vehicle;
import org.upjs.ewheel.vehicles.VehiclesDao;

public class DashBoardController {

    private final TripsDao tripsDao = DaoFactory.INSTANCE.getTripsDao();
    private final VehiclesDao vehiclesDao = DaoFactory.INSTANCE.getVehiclesDao();

    @FXML
    private Button addRequestButton;

    @FXML
    private Text categoryData;

    @FXML
    private Text categoryLabel;

    @FXML
    private BarChart<?, ?> chartTrips;

    @FXML
    private TextField fulltextInput;

    @FXML
    private Text isActiveData;

    @FXML
    private Text isActiveLabel;

    @FXML
    private Text kilometersData;

    @FXML
    private Text kilometersLabel;

    @FXML
    private ListView<Trip> listViewRecent;

    @FXML
    private Text numberTripsData;

    @FXML
    private Text numberTripsLabel;

    @FXML
    private SVGPath searchButton;

    @FXML
    private ChoiceBox<Vehicle> selectCar;

    @FXML
    void initialize() {
        listViewRecent.setItems(FXCollections.observableArrayList(tripsDao.listRecentTrips(5)));
        selectCar.setConverter(new StringConverter<>() {
            @Override
            public String toString(Vehicle v) {
                return v == null ? "" : v.name() + " (" + v.licencePlate() + ")";
            }
            @Override
            public Vehicle fromString(String s) {
                return null;
            }
        });
        selectCar.setItems(FXCollections.observableArrayList(vehiclesDao.findAll()));

        selectCar.getSelectionModel().selectedItemProperty().addListener((obs, old, v) -> {
            if (v == null) return;
            kilometersData.setText(v.kilometers().toString());
            kilometersLabel.setText("Kolemetre");
            categoryData.setText(v.category().name());
            categoryLabel.setText("Kategoria");
            isActiveData.setText(v.active() ? "Áno" : "Nie");
            isActiveLabel.setText("Je aktívne?");

        });
    }

}
