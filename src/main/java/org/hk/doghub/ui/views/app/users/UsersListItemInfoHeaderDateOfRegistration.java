package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.user.DogHubUser;

public class UsersListItemInfoHeaderDateOfRegistration extends Div {

    public static final String CLASS_NAME = UsersListItemInfoHeader.CLASS_NAME + "-date-of-registration";

    private final UserDateOfRegistration dateOfRegistration;

    public UsersListItemInfoHeaderDateOfRegistration(DogHubUser user) {
        addClassNames(CLASS_NAME);
        dateOfRegistration = new UserDateOfRegistration(user);
        add(dateOfRegistration);
    }
}
