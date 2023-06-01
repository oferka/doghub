package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UserDateOfBirthField extends DateTimePicker {

    public static final String CLASS_NAME = "user-date-of-birth-field";

    public static final String LABEL = "Date of Birth";

    public UserDateOfBirthField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getDateOfBirth() != null)?user.getDateOfBirth().toLocalDateTime() : null);
    }

    public ZonedDateTime getValueAsZonedDateTime() {
        return ((getValue() != null) ? ZonedDateTime.of(getValue(), ZoneId.systemDefault()) : null);
    }
}
