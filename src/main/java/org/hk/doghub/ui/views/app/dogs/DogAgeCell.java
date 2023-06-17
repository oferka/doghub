package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogAgeCell extends Span {

    public static final String CLASS_NAME = "dog-age-cell";

    public DogAgeCell(@NotNull DogHubDog dog) {
        super(dog.getAge());
        addClassName(CLASS_NAME);
    }
}
