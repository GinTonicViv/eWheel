package org.upjs.ewheel;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.trips.MysqlTripsDao;
import org.upjs.ewheel.trips.TripsDao;
import org.upjs.ewheel.vehicles.MysqlVehiclesDao;
import org.upjs.ewheel.vehicles.VehiclesDao;

public enum DaoFactory {
    INSTANCE;
    private TripsDao tripsDao;
    private VehiclesDao vehiclesDao;
    private static final JdbcTemplate jdbc;
    static {
        var ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3307/eWheelDB");
        ds.setUser(System.getenv("MYSQL_USER"));
        ds.setPassword(System.getenv("MYSQL_PASSWORD"));
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
}
