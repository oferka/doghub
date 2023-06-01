package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.textfield.IntegerField;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.user.DogHubUser;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.data.value.ValueChangeMode.EAGER;

public class UserStreetNumberField extends IntegerField {

    public static final String CLASS_NAME = "user-street-number-field";

    public static final String LABEL = "Number";

    public UserStreetNumberField() {
        addClassName(CLASS_NAME);
        setLabel(LABEL);
        setMin(1);
        setMax(100000);
        setStepButtonsVisible(true);
        setErrorMessage("Number must be between 1 and 100000");
        setValueChangeMode(EAGER);
    }

    public void setValue(@NotNull DogHubUser user) {
        setValue((user.getAddress() != null)?user.getAddress().getNumber() : 0);
    }

    public List<String> validateUserField() {
        List<String> result = new ArrayList<>();
        if(isInvalid()) {
            result.add(getErrorMessage());
        }
        return result;
    }
}
