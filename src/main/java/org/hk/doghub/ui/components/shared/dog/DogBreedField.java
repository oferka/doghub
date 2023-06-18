package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.BREED_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.CERTIFICATE_SOLID;

public class DogBreedField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-breed-field";

    public static final String LABEL = "Breed";

    public DogBreedField() {
        super(LABEL, BREED_MAX_LENGTH, CERTIFICATE_SOLID.create(), asList("Irish Spaniel", "Weimaraner", "Kerryblue Terrier", "Japanese Spaniel"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getBreed() != null) ? dog.getBreed() : EMPTY;
        setValueWithValidation(value);
    }
}
