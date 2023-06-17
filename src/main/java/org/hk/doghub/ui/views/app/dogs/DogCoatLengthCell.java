package org.hk.doghub.ui.views.app.dogs;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.model.dog.DogHubDog;

public class DogCoatLengthCell extends Span {

    public static final String CLASS_NAME = "dog-coat-length-cell";

    public DogCoatLengthCell(@NotNull DogHubDog dog) {
        super(dog.getCoatLength());
        addClassName(CLASS_NAME);
    }
}
