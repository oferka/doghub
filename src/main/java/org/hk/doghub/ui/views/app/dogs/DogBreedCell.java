package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogBreedCell extends Span {

    public static final String CLASS_NAME = "dog-breed-cell";

    public DogBreedCell(@NotNull DogHubDog dog) {
        super(dog.getBreed());
        addClassName(CLASS_NAME);
    }
}
