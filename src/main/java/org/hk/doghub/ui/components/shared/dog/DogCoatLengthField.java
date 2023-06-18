package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.COAT_LENGTH_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.OTTER_SOLID;

public class DogCoatLengthField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-coat-length-field";

    public static final String LABEL = "Coat Length";

    public DogCoatLengthField() {
        super(LABEL, COAT_LENGTH_MAX_LENGTH, OTTER_SOLID.create(), asList("hairless", "short", "medium", "long", "wire", "curly"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getCoatLength() != null) ? dog.getCoatLength() : EMPTY;
        setValueWithValidation(value);
    }
}
