package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class TipNameField extends TextField {

    public static final String CLASS_NAME = "tip-name-field";

    public static final String LABEL = "Name";

    public TipNameField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setMinLength(2);
        setMaxLength(128);
        setPrefixComponent(LINK.create());
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull NamedEntity entity) {
        @NotNull String name = entity.getName();
        setValue(name);
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
        if(value.length() < 2 || value.length() > 128) {
            result.add(format("{0} length must be between 2 and 128 characters", LABEL));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
