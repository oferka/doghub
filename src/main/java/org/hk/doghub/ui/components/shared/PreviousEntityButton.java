package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static org.vaadin.lineawesome.LineAwesomeIcon.ARROW_LEFT_SOLID;

@Slf4j
public class PreviousEntityButton extends Button {

    public static final String CLASS_NAME = "previous-entity-button";

    public PreviousEntityButton(String text) {
        addClassName(CLASS_NAME);
        setIcon(ARROW_LEFT_SOLID.create());
        setText(text);
        addClickListener(this::previousEntityClicked);
    }

    private void previousEntityClicked(ClickEvent<Button> event) {
        log.info("Previous entity clicked");
    }
}
