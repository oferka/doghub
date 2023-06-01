package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.EmailField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserEmailField extends EmailField {

    public static final String CLASS_NAME = "user-email-field";

    public static final String LABEL = "Email";

    public UserEmailField() {
        addClassName(CLASS_NAME);
        setPlaceholder(LABEL);
        setMinLength(5);
        setMaxLength(128);
        getElement().setAttribute("name", "email");
        setErrorMessage(format("Please enter a valid {0} address", LABEL));
        setClearButtonVisible(true);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getEmail() != null)?user.getEmail() : EMPTY);
    }

    public List<String> validateUserField() {
        List<String> result = new ArrayList<>();
        if(isInvalid()) {
            result.add(getErrorMessage());
        }
        return result;
    }
}
