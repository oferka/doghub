package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewBody extends HorizontalLayout {

    public static final String CLASS_NAME = TipCreationView.CLASS_NAME + "-body";

    public TipCreationViewBody(AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        add(new Span("tip creation body"));
    }
}
