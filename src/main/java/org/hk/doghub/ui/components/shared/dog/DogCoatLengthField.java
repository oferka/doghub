package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.TEXT_INPUT;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.COAT_LENGTH_MAX_LENGTH;

public class DogCoatLengthField extends EditableTextField {

    public static final String CLASS_NAME = "dog-coat-length-field";

    public static final String LABEL = "Coat Length";

    public DogCoatLengthField() {
        super(LABEL, false, COAT_LENGTH_MAX_LENGTH, TEXT_INPUT.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = dog.getCoatLength();
        setValue((value != null) ? value : EMPTY);
    }
}
