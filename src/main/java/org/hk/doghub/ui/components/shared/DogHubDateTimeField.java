package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;

public class DogHubDateTimeField extends DateTimePicker {

    public static final String CLASS_NAME = "dog-hub-date-time-field";

    public DogHubDateTimeField(String label, boolean readOnly) {
        addClassName(CLASS_NAME);
        setLabel(label);
        setReadOnly(readOnly);
        addValueChangeListener(this::valueChanged);
    }

    private void valueChanged(ComponentValueChangeEvent<DateTimePicker, LocalDateTime> event) {
        LocalDateTime value = event.getValue();
        setValueWithValidation(value);
    }

    private void setValueWithValidation(LocalDateTime value) {
        List<String> violations = validateField(value);
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

    private List<String> validateField(LocalDateTime value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.isAfter(LocalDateTime.now())) {
            result.add(format("{0} Must be a valid date and time", getLabel()));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
