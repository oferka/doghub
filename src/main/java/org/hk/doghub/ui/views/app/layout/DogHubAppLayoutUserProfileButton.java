package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.vaadin.lineawesome.LineAwesomeIcon.ID_CARD_SOLID;

@Slf4j
public class DogHubAppLayoutUserProfileButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-profile-button";

    public DogHubAppLayoutUserProfileButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Profile");
        setTooltipText("Profile");
        setIcon(ID_CARD_SOLID.create());
        addClickListener(this::profileClicked);
    }

    private void profileClicked(ClickEvent<Button> event) {
        log.info("Profile clicked");
    }
}
