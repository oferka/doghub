package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_N;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.PLUS_CIRCLE;
import static java.text.MessageFormat.format;

@Slf4j
public class EntitiesViewHeaderActionsNewButton extends Button {

    public static final String CLASS_NAME = EntitiesViewHeaderActions.CLASS_NAME + "-new-button";

    public EntitiesViewHeaderActionsNewButton(@NotNull String entityName) {
        addClassName(CLASS_NAME);
        setIcon(PLUS_CIRCLE.create());
        setText(format("New {0}", entityName));
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::newClicked);
        addClickShortcut(KEY_N, ALT);
    }

    private void newClicked(ClickEvent<Button> event) {
        log.info("New entity clicked");
    }
}
