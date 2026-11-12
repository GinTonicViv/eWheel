package org.upjs.ewheel.users;

import org.upjs.ewheel.users.driving_licence_rights.Category;

import java.util.List;
import java.util.UUID;

public interface UsersDao {
    User create(User user);

    User update(User user);

    User findById(UUID id);

    User findByEmail(String email);

    List<User> findByFullName(String firstName, String lastName);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByRole(Role role);

    List<User> searchUser(String query);

    List<User> findAll();

    List<Category> listUsersDrivingLicenceRights();

    void deactivate(UUID id);

    User reactivate(UUID id);
}
