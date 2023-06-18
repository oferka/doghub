package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.TextField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.NamedEntity;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.hk.doghub.model.NamedEntity.NAME_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.FILE_SIGNATURE_SOLID;

public class NameField extends TextField {

    public static final String CLASS_NAME = "name-field";

    public static final String LABEL = "Name";

    public NameField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setMaxLength(NAME_MAX_LENGTH);
        setPrefixComponent(FILE_SIGNATURE_SOLID.create());
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
        if(value == null || value.length() > NAME_MAX_LENGTH) {
            result.add(format("{0} length must up to {1} characters", LABEL, NAME_MAX_LENGTH));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
