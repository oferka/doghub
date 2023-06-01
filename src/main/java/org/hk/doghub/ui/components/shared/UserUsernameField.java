package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import static com.vaadin.flow.component.icon.VaadinIcon.USER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class UserUsernameField extends TextField {

    public static final String CLASS_NAME = "user-username-field";

    public static final String LABEL = "User Name";

    public UserUsernameField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setMinLength(5);
        setMaxLength(128);
        setPrefixComponent(USER.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        @NotNull String username = user.getUsername();
        setValue(username);
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
            setErrorMessage(format("{0} length must be between 5 and 128 characters", LABEL));
        }
    }

    private boolean isValidValue(@NotNull String value) {
        return(value.length() >= 5 && value.length() <= 128);
    }
}
