package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;

public class UserDateOfRegistrationField extends DateTimePicker {

    public static final String CLASS_NAME = "user-date-of-registration-field";

    public static final String LABEL = "Date of Registration";

    public UserDateOfRegistrationField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setReadOnly(true);
        addValueChangeListener(this::valueChanged);
    }

    private void valueChanged(ComponentValueChangeEvent<DateTimePicker, LocalDateTime> event) {
        LocalDateTime value = event.getValue();
        setValueWithValidation(value);
    }

    public void setValue(@NotNull DogHubUser user) {
        LocalDateTime value = (user.getDateOfRegistration() != null) ? user.getDateOfRegistration().toLocalDateTime() : null;
        setValue(value);
    }

    private void setValueWithValidation(LocalDateTime value) {
        List<String> violations = validateUserField(value);
        if(violations.isEmpty()) {
            setValue(value);
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    public ZonedDateTime getValueAsZonedDateTime() {
        return ((getValue() != null) ? ZonedDateTime.of(getValue(), ZoneId.systemDefault()) : null);
    }

    private List<String> validateUserField(LocalDateTime value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.isAfter(LocalDateTime.now())) {
            result.add(format("{0} Must be a valid date and time", LABEL));
        }
        return result;
    }

    public List<String> validateUserField() {
        return validateUserField(getValue());
    }
}
