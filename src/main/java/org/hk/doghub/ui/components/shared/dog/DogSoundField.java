package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.EditableTextField;

import static com.vaadin.flow.component.icon.VaadinIcon.TEXT_INPUT;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hk.doghub.model.dog.DogHubDog.SOUND_MAX_LENGTH;

public class DogSoundField extends EditableTextField {

    public static final String CLASS_NAME = "dog-sound-field";

    public static final String LABEL = "Sound";

    public DogSoundField() {
        super(LABEL, false, SOUND_MAX_LENGTH, TEXT_INPUT.create(), null);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        String value = dog.getSound();
        setValue((value != null) ? value : EMPTY);
    }
}
