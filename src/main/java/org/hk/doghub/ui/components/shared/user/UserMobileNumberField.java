package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.icon.VaadinIcon.PHONE;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class UserMobileNumberField extends TextField {

    public static final String CLASS_NAME = "user-mobile-number-field";

    public static final String LABEL = "Mobile Phone";

    public UserMobileNumberField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setMinLength(2);
        setMaxLength(64);
        setAllowedCharPattern("[0-9()+-]");
        setPrefixComponent(PHONE.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        String value = user.getMobileNumber();
        setValue((value != null) ? value : EMPTY);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(String value) {
        List<String> violations = validateUserField(value);
        if(violations.isEmpty()) {
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    private List<String> validateUserField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() < 2 || value.length() > 128) {
            result.add(format("{0} length must be between 2 and 128 characters", LABEL));
        }
        return result;
    }

    public List<String> validateUserField() {
        return validateUserField(getValue());
    }
}
