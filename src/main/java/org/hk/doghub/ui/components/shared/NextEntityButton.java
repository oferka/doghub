package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static org.vaadin.lineawesome.LineAwesomeIcon.ARROW_RIGHT_SOLID;

@Slf4j
public class NextEntityButton extends Button {

    public static final String CLASS_NAME = "next-entity-button";

    public NextEntityButton(String text) {
        addClassName(CLASS_NAME);
        setIcon(ARROW_RIGHT_SOLID.create());
        setIconAfterText(true);
        setText(text);
        addClickListener(this::nextEntityClicked);
    }

    private void nextEntityClicked(ClickEvent<Button> event) {
        log.info("Next entity clicked");
    }
}
