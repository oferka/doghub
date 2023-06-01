package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.text.MessageFormat.format;

public class UserDateOfBirthField extends DateTimePicker {

    public static final String CLASS_NAME = "user-date-of-birth-field";

    public static final String LABEL = "Date of Birth";

    public UserDateOfBirthField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        addValueChangeListener(this::valueChanged);
    }

    private void valueChanged(ComponentValueChangeEvent<DateTimePicker, LocalDateTime> event) {
        LocalDateTime value = event.getValue();
        setValueWithValidation(value);
    }

    public void setValue(@NotNull DogHubUser user) {
        LocalDateTime value = (user.getDateOfBirth() != null) ? user.getDateOfBirth().toLocalDateTime() : null;
        setValue(value);
    }

    private void setValueWithValidation(LocalDateTime value) {
        if(isValidValue(value)) {
            setValue(value);
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(format("Must be a valid date & time"));
        }
    }

    public ZonedDateTime getValueAsZonedDateTime() {
        return ((getValue() != null) ? ZonedDateTime.of(getValue(), ZoneId.systemDefault()) : null);
    }

    private boolean isValidValue(LocalDateTime value) {
        return(value != null && value.isBefore(LocalDateTime.now()));
    }
}
