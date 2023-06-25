package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.textfield.EmailField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.user.DogHubUser.EMAIL_MAX_LENGTH;

public class UserEmailField extends EmailField {

    public static final String CLASS_NAME = "user-email-field";

    public static final String LABEL = "Email";

    public static final String ERROR_MESSAGE = "Please enter a valid email address";

    public UserEmailField() {
        addClassName(CLASS_NAME);
        setPlaceholder(LABEL);
        setMaxLength(EMAIL_MAX_LENGTH);
        getElement().setAttribute("name", "email");
        setErrorMessage(ERROR_MESSAGE);
        setClearButtonVisible(true);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getEmail() != null)?user.getEmail() : EMPTY);
    }

    public List<String> validateField() {
        List<String> result = new ArrayList<>();
        if(isInvalid()) {
            result.add(getErrorMessage());
        }
        return result;
    }
}
