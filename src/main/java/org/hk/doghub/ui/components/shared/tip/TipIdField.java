package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.textfield.BigDecimalField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.tip.DogHubTip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class TipIdField extends BigDecimalField {

    public static final String CLASS_NAME = "tip-id-field";

    public static final String LABEL = "ID";

    public TipIdField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubTip tip) {
        @NotNull Long tipId = tip.getId();
        setValue(new BigDecimal(tipId));
    }

    public long getValueAsLong() {
        return getValue().longValue();
    }

    private void valueChanged(ComponentValueChangeEvent<BigDecimalField, BigDecimal> event) {
        @NotNull BigDecimal value = event.getValue();
        validateValue(value);
    }

    private void validateValue(@NotNull BigDecimal value) {
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

    private List<String> validateTipField(@NotNull BigDecimal value) {
        List<String> result = new ArrayList<>();
        if(value.longValue() <= 0) {
            result.add(format("{0} must be positive", LABEL));
        }
        return result;
    }

    public List<String> validateTipField() {
        return validateTipField(getValue());
    }
}
