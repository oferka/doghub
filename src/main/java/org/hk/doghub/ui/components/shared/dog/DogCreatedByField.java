package org.hk.doghub.ui.components.shared.dog;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.vaadin.lineawesome.LineAwesomeIcon.USER_SOLID;

public class DogCreatedByField extends TextField {

    public static final String CLASS_NAME = "dog-created-by-field";

    public static final String LABEL = "Created By";

    public DogCreatedByField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setMinLength(2);
        setMaxLength(128);
        setPrefixComponent(USER_SOLID.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubDog dog) {
        @NotNull String value = dog.getCreatedBy().getUsername();
        setValue(value);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        @NotNull String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(String value) {
        List<String> violations = validateTipField(value);
        if(violations.isEmpty()) {
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    private List<String> validateTipField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() < 5 || value.length() > 128) {
            result.add(format("{0} length must be between 5 and 128 characters", LABEL));
        }
        return result;
    }

    public List<String> validateTipField() {
        return validateTipField(getValue());
    }
}
