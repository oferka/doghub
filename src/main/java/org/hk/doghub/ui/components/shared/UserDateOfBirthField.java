package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;

public class UserDateOfBirthField extends DateTimePicker {

    public static final String CLASS_NAME = "user-date-of-birth-field";

    public static final String LABEL = "Date of Birth";

    public UserDateOfBirthField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
    }
}
