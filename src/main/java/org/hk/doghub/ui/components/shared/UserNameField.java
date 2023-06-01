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
        setMinLength(2);
        setMaxLength(128);
        setPrefixComponent(USER.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        @NotNull String value = user.getName();
        setValue(value);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        @NotNull String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(@NotNull String value) {
        if(isValidValue(value)) {
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(format("{0} length must be between 2 and 128 characters", LABEL));
        }
    }

    private boolean isValidValue(@NotNull String value) {
        return(value.length() >= 2 && value.length() <= 128);
    }
}
