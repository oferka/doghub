package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.BigDecimalField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.math.BigDecimal;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;
import static java.text.MessageFormat.format;

public class UserIdField extends BigDecimalField {

    public static final String CLASS_NAME = "user-id-field";

    public static final String LABEL = "ID";

    public UserIdField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setRequiredIndicatorVisible(true);
        setReadOnly(true);
        setValueChangeMode(EAGER);
        addValueChangeListener(this::valueChanged);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue(new BigDecimal(user.getId()));
    }

    public long getValueAsLong() {
        return getValue().longValue();
    }

    private void valueChanged(ComponentValueChangeEvent<BigDecimalField, BigDecimal> event) {
        BigDecimal value = event.getValue();
        if(isValidValue(value)) {
            event.getSource().setInvalid(false);
            event.getSource().setErrorMessage(null);
        }
        else {
            event.getSource().setInvalid(true);
            event.getSource().setErrorMessage(format("{0} must be a positive number", LABEL));
        }
    }

    private boolean isValidValue(BigDecimal value) {
        return(value.longValue() > 0);
    }
}
