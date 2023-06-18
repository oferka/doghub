package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.AGE_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.BABY_CARRIAGE_SOLID;

public class DogAgeField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-age-field";

    public static final String LABEL = "Age";

    public DogAgeField() {
        super(LABEL, AGE_MAX_LENGTH, BABY_CARRIAGE_SOLID.create(), asList("puppy", "young", "adult", "senior"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getAge() != null) ? dog.getAge() : EMPTY;
        setValueWithValidation(value);
    }
}
