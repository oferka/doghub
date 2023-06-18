package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.GENDER_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.MERCURY_SOLID;

public class DogGenderField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-gender-field";

    public static final String LABEL = "Gender";

    public DogGenderField() {
        super(LABEL, GENDER_MAX_LENGTH, MERCURY_SOLID.create(), asList("female", "male"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getGender() != null) ? dog.getGender() : EMPTY;
        setValueWithValidation(value);
    }
}
