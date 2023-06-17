package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogSizeCell extends Span {

    public static final String CLASS_NAME = "dog-size-cell";

    public DogSizeCell(@NotNull DogHubDog dog) {
        super(dog.getSize());
        addClassName(CLASS_NAME);
    }
}
