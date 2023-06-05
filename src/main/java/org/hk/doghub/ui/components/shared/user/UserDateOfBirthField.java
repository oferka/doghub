package org.hk.doghub.ui.components.shared.user;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;
import org.hk.doghub.ui.components.shared.DogHubDateTimeField;

import java.time.LocalDateTime;

public class UserDateOfBirthField extends DogHubDateTimeField {

    public static final String CLASS_NAME = "user-date-of-birth-field";

    public static final String LABEL = "Date of Birth";

    public UserDateOfBirthField() {
        super(LABEL, false);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubUser user) {
        LocalDateTime value = (user.getDateOfBirth() != null) ? user.getDateOfBirth().toLocalDateTime() : null;
        setValue(value);
    }
}
