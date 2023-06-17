package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogGenderCell extends Span {

    public static final String CLASS_NAME = "dog-gender-cell";

    public DogGenderCell(@NotNull DogHubDog dog) {
        super(dog.getGender());
        addClassName(CLASS_NAME);
    }
}
