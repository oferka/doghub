package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;

public class UserDateOfRegistrationField extends DateTimePicker {

    public static final String CLASS_NAME = "user-date-of-registration-field";

    public static final String LABEL = "Date of Registration";

    public UserDateOfRegistrationField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setReadOnly(true);
    }
}
