package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class ReadOnlyTextField extends TextField {

    public static final String CLASS_NAME = "read-only-text-field";

    public ReadOnlyTextField(String label, boolean required, int minLength, int maxLength, Component prefixComponent) {
        addClassName(CLASS_NAME);
        setLabel(label);
        setRequiredIndicatorVisible(required);
        setReadOnly(true);
        setMinLength(minLength);
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

    private List<String> validateField(@NotNull String value) {
        List<String> result = new ArrayList<>();
        if(value.length() < getMinLength() || value.length() > getMaxLength()) {
            result.add(format("{0} length must be between {1} and {2} characters", getLabel(), getMinLength(), getMaxLength()));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
