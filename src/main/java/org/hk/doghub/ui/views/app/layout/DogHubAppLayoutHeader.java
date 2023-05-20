package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import jakarta.validation.constraints.NotNull;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;

public class DogHubAppLayoutHeader extends HorizontalLayout {

    public static final String CLASS_NAME = DogHubAppLayout.ID + "-header";

    private final DogHubAppLayoutHeaderContent content;
    private final DogHubAppLayoutHeaderActions actions;

    public DogHubAppLayoutHeader(AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setPadding(true);
        setJustifyContentMode(BETWEEN);

        content = new DogHubAppLayoutHeaderContent();
        add(content);

        actions = new DogHubAppLayoutHeaderActions(authenticatedUser);
        add(actions);
    }

    public void setTitleText(@NotNull String titleText) {
        content.setTitleText(titleText);
    }
}
