package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.html.Span;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

public class TipCreationViewHeaderInfoDescription extends Span {

    public static final String CLASS_NAME = TipCreationViewHeaderInfo.CLASS_NAME + "-description";

    public TipCreationViewHeaderInfoDescription(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setDescriptionText("Add some interesting tip to DogHub");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}