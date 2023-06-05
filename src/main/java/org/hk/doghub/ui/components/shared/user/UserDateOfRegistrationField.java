package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubDateTimeField;

import java.time.LocalDateTime;

public class UserDateOfRegistrationField extends DogHubDateTimeField {

    public static final String CLASS_NAME = "user-date-of-registration-field";

    public static final String LABEL = "Date of Registration";

    public UserDateOfRegistrationField() {
        super(LABEL, true, true);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        LocalDateTime value = (user.getDateOfRegistration() != null) ? user.getDateOfRegistration().toLocalDateTime() : null;
        setValue(value);
    }
}
