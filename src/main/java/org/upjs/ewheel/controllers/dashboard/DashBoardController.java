package org.upjs.ewheel.controllers.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import org.upjs.ewheel.DaoFactory;
import org.upjs.ewheel.UuidUtil;
import org.upjs.ewheel.trips.Trip;
import org.upjs.ewheel.trips.TripRecords.TripRowAnalytics;
import org.upjs.ewheel.trips.TripsDao;
import org.upjs.ewheel.vehicles.Vehicle;
import org.upjs.ewheel.vehicles.VehiclesDao;

import java.util.ArrayList;
import java.util.UUID;

public class DashBoardController {

    private final TripsDao tripsDao = DaoFactory.INSTANCE.getTripsDao();
    private final VehiclesDao vehiclesDao = DaoFactory.INSTANCE.getVehiclesDao();

    private final ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
    private UUID selectedVehicle = null;
    private final ObservableList<TripRowAnalytics> recentTrips = FXCollections.observableArrayList();

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
    private ListView<TripRowAnalytics> listViewRecent;

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
        //choicebox
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
        vehicles.setAll(vehiclesDao.findAll());
        selectCar.setItems(vehicles);

        selectCar.getSelectionModel().selectedItemProperty().addListener((obs, old, v) -> {
            if (v == null) return;
            //data
            selectedVehicle = v.uuid();
            recentTrips.setAll(tripsDao.listTripsOfVehicleAnalytics(selectedVehicle, 5));
            kilometersData.setText(v.kilometers().toString());
            kilometersLabel.setText("Kilometre");
            categoryData.setText(v.category().name());
            categoryLabel.setText("Kategoria");
            isActiveData.setText(v.active() ? "Áno" : "Nie");
            isActiveLabel.setText("Je aktívne?");
        });

        //listview
        listViewRecent.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(TripRowAnalytics t, boolean empty) {
                super.updateItem(t, empty);
                setText(empty || t == null ? null
                        : t.startDate().toLocalDate() + "  " + t.fullName() + "  (" + t.status() + ")");
            }
        });

        listViewRecent.setItems(recentTrips);
    }

}
