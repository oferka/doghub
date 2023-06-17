package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogSoundCell extends Span {

    public static final String CLASS_NAME = "dog-sound-cell";

    public DogSoundCell(@NotNull DogHubDog dog) {
        super(dog.getSound());
        addClassName(CLASS_NAME);
    }
}
