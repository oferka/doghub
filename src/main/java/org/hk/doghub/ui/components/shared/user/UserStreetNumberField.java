package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.textfield.IntegerField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;

public class UserStreetNumberField extends IntegerField {

    public static final String CLASS_NAME = "user-street-number-field";

    public static final String LABEL = "Number";

    public static final int MIN_VALUE = 1;

    public UserStreetNumberField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setMin(MIN_VALUE);
        setStepButtonsVisible(true);
        setErrorMessage("Number must be positive");
        setValueChangeMode(EAGER);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getAddress() != null && user.getAddress().getNumber() != null) ? user.getAddress().getNumber() : MIN_VALUE);
    }

    public List<String> validateField() {
        List<String> result = new ArrayList<>();
        if(isInvalid()) {
            result.add(getErrorMessage());
        }
        return result;
    }
}
