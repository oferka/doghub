package org.hk.doghub.ui.views.app.layout;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_ICON;
import static org.vaadin.lineawesome.LineAwesomeIcon.QUESTION_CIRCLE_SOLID;

@Slf4j
public class HelpButton extends Button {

    public static final String CLASS_NAME = "help-button";

    public HelpButton() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_ICON);
        getElement().setAttribute("aria-label", "Help");
        setTooltipText("Help");
        setIcon(QUESTION_CIRCLE_SOLID.create());
        addClickListener(this::helpClicked);
    }

    private void helpClicked(ClickEvent<Button> event) {
        log.info("Help clicked");
    }
}
