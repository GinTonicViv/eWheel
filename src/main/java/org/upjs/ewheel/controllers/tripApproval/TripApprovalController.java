package org.upjs.ewheel.controllers.tripApproval;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.DaoFactory;
import org.upjs.ewheel.trips.TripData;
import org.upjs.ewheel.trips.TripsDao;
import org.upjs.ewheel.users.UserData;
import org.upjs.ewheel.users.UsersDao;
import org.upjs.ewheel.vehicles.VehicleData;
import org.upjs.ewheel.vehicles.VehiclesDao;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class TripApprovalController {

    private final TripsDao tripsDao = DaoFactory.INSTANCE.getTripsDao();
    private ObservableList<TripData> tripsData = FXCollections.observableArrayList();
    private final UsersDao usersDao = DaoFactory.INSTANCE.getUsersDao();
    private ObservableList<UserData> usersData = FXCollections.observableArrayList();
    private final VehiclesDao vehiclesDao = DaoFactory.INSTANCE.getVehiclesDao();
    private ObservableList<VehicleData> vehiclesData = FXCollections.observableArrayList();

    private Integer limit = 20;
    private Integer offset = 0;
    private Integer page = 1;

    @FXML
    private TableView<TripData> tableView;

    @FXML
    private DatePicker DateToDatePicker;

    @FXML
    private TextField approvalTextField;

    @FXML
    private DatePicker dateFromDatePicker;

    @FXML
    private Label currPageNum;

    @FXML
    private Label pageCount;

    @FXML
    private Button filterButton;

    @FXML
    private StackPane nextPageStackPaneBUtton;

    @FXML
    private StackPane previousPageStackPaneButton;

    @FXML
    private Button saveChangesButton;

    @FXML
    private ChoiceBox<?> statusChoiceBox;

    @FXML
    private ListView<TripData> tripsListView;

    @FXML
    private ChoiceBox<UserData> userChoiceBox;

    @FXML
    private ChoiceBox<VehicleData> vehicleChoiceBox;

    public void initialize() {
        //inicializacia listview ziadosti
        tripsListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(TripData t, boolean empty) {
                super.updateItem(t, empty);
                setText(empty || t == null ? null
                        : "Používateľ " + t.userFullName() + " žiadá o vozidlo " + t.vehicleName() + " dňa " + t.startDate().toLocalDate() + " pre " + t.reason());
            }
        });

        tripsData.setAll(tripsDao.listTripRequests(this.limit, this.offset, null, null, null, null));
        tripsListView.setItems(tripsData);

        //inicializacia select zamestnanci
        userChoiceBox.setConverter(new  StringConverter<UserData>() {
            @Override
            public String toString(UserData user) {
                return user == null ?  "" : user.name() + " " + user.last_name();
            }
            @Override
            public UserData fromString(String string) {
                return null;
            }
        });
        usersData.setAll(usersDao.findAll());
        userChoiceBox.setItems(usersData);

        //inicializacie select vozidla
        vehicleChoiceBox.setConverter(new  StringConverter<VehicleData>() {
            @Override
            public String toString(VehicleData vehicle) {
                return vehicle == null ?  "" : vehicle.name() + " (" + vehicle.licencePlate() + ")";
            }
            @Override
            public VehicleData fromString(String string) {
                return null;
            }
        });
        vehiclesData.setAll(vehiclesDao.findAll());
        vehicleChoiceBox.setItems(vehiclesData);
        setCounterPages();
    };

    //pomocne funkcie na prepocet stranokovania
    private void setCounterPages(){
        currPageNum.setText(String.valueOf(this.page));
        if(tripsData.isEmpty()){
            pageCount.setText("0");
        }else{
            pageCount.setText(String.valueOf(tripsData.get(0).count_pages() == null ? 0 : (int) Math.ceil((double) tripsData.get(0).count_pages() / this.limit)));
        }
    }

    private void setNextPage() {
        page += 1;
        offset = (page - 1) * limit;
        currPageNum.setText(String.valueOf(this.page));
    }

    //aplikovanie filtrov
    @FXML
    void applyFilters(ActionEvent event) {
        UUID selectedVehicle = vehicleChoiceBox.getSelectionModel().selectedItemProperty().getValue() == null ? null : vehicleChoiceBox.getSelectionModel().selectedItemProperty().getValue().uuid();
        UUID selectedUser = userChoiceBox.getSelectionModel().selectedItemProperty().getValue() == null ? null :  userChoiceBox.getSelectionModel().selectedItemProperty().getValue().uuid();
        LocalDate selectedFrom = dateFromDatePicker.getValue() == null ? null : dateFromDatePicker.getValue();
        LocalDate selectedTo = DateToDatePicker.getValue() == null ? null : DateToDatePicker.getValue();

        tripsData.setAll(tripsDao.listTripRequests(this.limit, this.offset, selectedUser, selectedVehicle, selectedFrom, selectedTo));

        setCounterPages();
    }

}