package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubComboBoxField;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.SOUND_MAX_LENGTH;
import static org.vaadin.lineawesome.LineAwesomeIcon.MICROPHONE_SOLID;

public class DogSoundField extends DogHubComboBoxField {

    public static final String CLASS_NAME = "dog-sound-field";

    public static final String LABEL = "Sound";

    public DogSoundField() {
        super(LABEL, SOUND_MAX_LENGTH, MICROPHONE_SOLID.create(), asList("woof", "woof woof", "bow wow", "ruff", "owooooo", "grrrrrr"));
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = (dog.getSound() != null) ? dog.getSound() : EMPTY;
        setValueWithValidation(value);
    }
}
