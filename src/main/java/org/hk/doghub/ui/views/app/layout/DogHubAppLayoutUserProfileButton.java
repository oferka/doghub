package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static com.vaadin.flow.component.icon.VaadinIcon.USER_CARD;

@Slf4j
public class DogHubAppLayoutUserProfileButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-profile-button";

    public DogHubAppLayoutUserProfileButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Profile");
        setTooltipText("Profile");
        Icon profileIcon = USER_CARD.create();
        setIcon(profileIcon);
        addClickListener(this::profileClicked);
    }

    private void profileClicked(ClickEvent<Button> event) {
        log.info("Profile clicked");
    }
}
