package org.hk.doghub.ui.components.shared.dog;

import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;
import org.hk.doghub.ui.components.shared.DogHubDateTimeField;

import java.time.LocalDateTime;

public class DogCreationTimeField extends DogHubDateTimeField {

    public static final String CLASS_NAME = "dog-creation-time-field";

    public static final String LABEL = "Creation Time";

    public DogCreationTimeField() {
        super(LABEL, true, true);
        addClassName(CLASS_NAME);
    }

    public void setValue(@NotNull DogHubDog dog) {
        LocalDateTime value = (dog.getCreationTime() != null) ? dog.getCreationTime().toLocalDateTime() : null;
        setValue(value);
    }
}
