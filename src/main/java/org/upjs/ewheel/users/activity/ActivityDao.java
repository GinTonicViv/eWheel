package org.upjs.ewheel.users.activity;

import org.upjs.ewheel.users.User;

import java.util.List;
import java.util.UUID;

public interface ActivityDao {
    Activity create(Activity activity);

    Activity update(Activity activity);

    Activity findById(UUID id);

    List<Activity> findByAction(String action);

    List<Activity> findByUser(User user);

    List<Activity> findByActivityStatus(ActivityStatus activityStatus);

    List<Activity> findAll();

    void deactivate(UUID id);

    Activity reactivate(UUID id);
}
