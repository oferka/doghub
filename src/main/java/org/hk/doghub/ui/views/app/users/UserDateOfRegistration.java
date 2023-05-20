package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.component.html.Span;
import org.hk.doghub.model.user.DogHubUser;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;

public class UserDateOfRegistration extends Span {

    public static final String CLASS_NAME = "user-date-of-registration";

    public UserDateOfRegistration(DogHubUser user) {
        addClassName(CLASS_NAME);
        ZonedDateTime dateOfRegistration = user.getDateOfRegistration();
        if(dateOfRegistration != null) {
            setText(dateOfRegistration.format(DateTimeFormatter.ofLocalizedDate(MEDIUM)));
        }
    }
}
