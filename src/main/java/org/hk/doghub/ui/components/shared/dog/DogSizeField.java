package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.SIZE_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.COMPRESS_SOLID;

public class DogSizeField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-size-field";

    public static final String LABEL = "Size";

    public DogSizeField() {
        super(LABEL, SIZE_MAX_LENGTH, COMPRESS_SOLID.create(), asList("small", "medium", "large", "extra large"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getSize() != null) ? dog.getSize() : EMPTY;
        setValueWithValidation(value);
    }
}
