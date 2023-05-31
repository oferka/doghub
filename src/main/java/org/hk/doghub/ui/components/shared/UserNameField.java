package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.USER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class UserNameField extends TextField {

    public static final String CLASS_NAME = "user-name-field";

    public static final String LABEL = "Name";

    public UserNameField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setMinLength(2);
        setMaxLength(128);
        setPrefixComponent(USER.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue(user.getName());
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        if(isValidValue(value)) {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
        else {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage(format("{0} length must be between 2 and 128 characters", LABEL));
        }
    }

    private boolean isValidValue(String value) {
        return(value.length() >= 2 && value.length() <= 128);
    }
}
