package org.upjs.ewheel;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.trips.MysqlTripsDao;
import org.upjs.ewheel.trips.TripsDao;
import org.upjs.ewheel.users.MysqlUsersDao;
import org.upjs.ewheel.users.UsersDao;
import org.upjs.ewheel.users.driving_licence_rights.DrivingLicenceRightsDao;
import org.upjs.ewheel.users.driving_licence_rights.DrivingLicenseRights;
import org.upjs.ewheel.users.driving_licence_rights.MysqlDrivingLicenceRightsDao;
import org.upjs.ewheel.vehicles.MysqlVehiclesDao;
import org.upjs.ewheel.vehicles.VehiclesDao;

import java.util.UUID;

public enum DaoFactory {
    INSTANCE;
    private TripsDao tripsDao;
    private VehiclesDao vehiclesDao;
    private UsersDao usersDao;
    private DrivingLicenceRightsDao drivingLicenseRightsDao;

    private static final JdbcTemplate jdbc;
    static {
        var ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3307/eWheelDB");
        ds.setUser("admin");
        ds.setPassword("yN7lL*KBcQ32");
        jdbc = new JdbcTemplate(ds);
    }

    public TripsDao getTripsDao() {
        tripsDao = new MysqlTripsDao(jdbc);
        return tripsDao;
    }

    public VehiclesDao getVehiclesDao() {
        vehiclesDao = new MysqlVehiclesDao(jdbc);
        return vehiclesDao;
    }

    public UsersDao getUsersDao() {
        usersDao = new MysqlUsersDao(jdbc);
        return usersDao;
    }

    public DrivingLicenceRightsDao getDrivingLicenseRightsDao() {
        drivingLicenseRightsDao = new MysqlDrivingLicenceRightsDao(jdbc);
        return drivingLicenseRightsDao;
    }
}
