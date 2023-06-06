package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class DogHubTextField extends TextField {

    public static final String CLASS_NAME = "dog-hub-text-field";

    public DogHubTextField(String label, boolean required, boolean readOnly, int maxLength, Component prefixComponent, String allowedCharPattern) {
        addClassName(CLASS_NAME);
        setLabel(label);
        setRequiredIndicatorVisible(required);
        setReadOnly(readOnly);
        setAllowedCharPattern(allowedCharPattern);
        setMaxLength(maxLength);
        setPrefixComponent(prefixComponent);
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    private void valueChanged(ComponentValueChangeEvent<TextField, String> event) {
        @NotNull String value = event.getValue();
        validateValue(value);
    }

    private void validateValue(@NotNull String value) {
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
        if(value != null && value.length() > getMaxLength()) {
            result.add(format("{0} length must be up to {1} characters", getLabel(), getMaxLength()));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
