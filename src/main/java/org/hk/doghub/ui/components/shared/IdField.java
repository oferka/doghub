package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.BigDecimalField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.AbstractEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;
import static org.vaadin.lineawesome.LineAwesomeIcon.ID_CARD_SOLID;

public class IdField extends BigDecimalField {

    public static final String CLASS_NAME = "id-field";

    public static final String LABEL = "ID";

    public IdField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setPrefixComponent(ID_CARD_SOLID.create());
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull AbstractEntity entity) {
        @NotNull Long userId = entity.getId();
        setValue(new BigDecimal(userId));
    }

    public long getValueAsLong() {
        return getValue().longValue();
    }

    private void valueChanged(ComponentValueChangeEvent<BigDecimalField, BigDecimal> event) {
        @NotNull BigDecimal value = event.getValue();
        validateValue(value);
    }

    private void validateValue(@NotNull BigDecimal value) {
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

    private List<String> validateField(@NotNull BigDecimal value) {
        List<String> result = new ArrayList<>();
        if(value.longValue() <= 0) {
            result.add(format("{0} must be positive", LABEL));
        }
        return result;
    }

    public List<String> validateField() {
        return validateField(getValue());
    }
}
