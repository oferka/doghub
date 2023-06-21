package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.vaadin.lineawesome.LineAwesomeIcon.COG_SOLID;

@Slf4j
public class DogHubAppLayoutUserSettingsButton extends Button {

    public static final String CLASS_NAME = DogHubAppLayoutHeader.CLASS_NAME + "-user-settings-button";

    public DogHubAppLayoutUserSettingsButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Settings");
        setTooltipText("Settings");
        setIcon(COG_SOLID.create());
        addClickListener(this::settingsClicked);
    }

    private void settingsClicked(ClickEvent<Button> event) {
        log.info("Settings clicked");
    }
}
