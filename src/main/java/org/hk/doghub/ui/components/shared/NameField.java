package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.icon.VaadinIcon.USER;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class NameField extends TextField {

    public static final String CLASS_NAME = "name-field";

    public static final String LABEL = "Name";

    public static final int MIN_LENGTH = 2;
    public static final int MAX_LENGTH = 128;

    public NameField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setMinLength(MIN_LENGTH);
        setMaxLength(MAX_LENGTH);
        setPrefixComponent(USER.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull NamedEntity entity) {
        @NotNull String value = entity.getName();
        setValue(value);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        @NotNull String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(String value) {
        List<String> violations = validateField(value);
        if(violations.isEmpty()) {
            setInvalid(false);
            setErrorMessage(null);
        }
        else {
            setInvalid(true);
            setErrorMessage(violations.get(0));
        }
    }

    private List<String> validateField(String value) {
        List<String> result = new ArrayList<>();
        if(value == null || value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            result.add(format("{0} length must be between {1} and {2} characters", LABEL, MIN_LENGTH, MAX_LENGTH));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
