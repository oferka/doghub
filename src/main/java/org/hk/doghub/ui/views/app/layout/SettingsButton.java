package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.vaadin.lineawesome.LineAwesomeIcon.COG_SOLID;

@Slf4j
public class SettingsButton extends Button {

    public static final String CLASS_NAME = "settings-button";

    public SettingsButton(@NotNull String text) {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Settings");
        setText(text);
        setTooltipText("Settings");
        setIcon(COG_SOLID.create());
        addClickListener(this::settingsClicked);
    }

    private void settingsClicked(ClickEvent<Button> event) {
        log.info("Settings clicked");
    }
}
