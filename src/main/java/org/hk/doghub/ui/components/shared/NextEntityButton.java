package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_RIGHT;

@Slf4j
public class NextEntityButton extends Button {

    public static final String CLASS_NAME = "next-entity-button";

    public NextEntityButton(String text) {
        addClassName(CLASS_NAME);
        setIcon(ARROW_RIGHT.create());
        setIconAfterText(true);
        setText(text);
        addClickListener(this::nextEntityClicked);
    }

    private void nextEntityClicked(ClickEvent<Button> event) {
        log.info("Next entity clicked");
    }
}
