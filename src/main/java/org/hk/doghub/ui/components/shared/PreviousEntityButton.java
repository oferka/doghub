package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_LEFT;
import static java.text.MessageFormat.format;

@Slf4j
public class PreviousEntityButton extends Button {

    public static final String CLASS_NAME = "previous-entity-button";

    public PreviousEntityButton(String text) {
        addClassName(CLASS_NAME);
        setIcon(ARROW_LEFT.create());
        setText(text);
        addClickListener(this::previousEntityClicked);
    }

    private void previousEntityClicked(ClickEvent<Button> event) {
        log.info(format("{0} clicked", getText()));
    }
}
