package org.upjs.ewheel.users;

import org.springframework.jdbc.core.JdbcTemplate;
import org.upjs.ewheel.users.driving_licence_rights.Category;

import java.util.List;
import java.util.UUID;

public class MysqlUsersDao implements UsersDao {

    private JdbcTemplate jdbc;

    public MysqlUsersDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        String sql = "SELECT * FROM User WHERE uuid = ?";
        List<User> users = jdbc.query(sql,new UserRowMapper(), id);

        if (users.isEmpty()) {
            return null;
        }else if(users.size() == 1){
            return users.get(0);
        }else{
            throw new RuntimeException("More than one user found with id: " + id);
        }
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findByFullName(String firstName, String lastName) {
        return List.of();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return List.of();
    }

    @Override
    public List<User> findByRole(Role role) {
        return List.of();
    }

    @Override
    public List<User> searchUser(String query) {
        return List.of();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public List<Category> listUsersDrivingLicenceRights() {
        return List.of();
    }

    @Override
    public void deactivate(UUID id) {

    }

    @Override
    public User reactivate(UUID id) {
        return null;
    }
}
