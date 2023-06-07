package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;
import static java.text.MessageFormat.format;

@Slf4j
public class EntitiesButton extends Button {

    public static final String CLASS_NAME = "entities-button";

    public EntitiesButton(String text) {
        addClassName(CLASS_NAME);
        setIcon(TABLE.create());
        setText(text);
        addClickListener(this::entitiesClicked);
    }

    private void entitiesClicked(ClickEvent<Button> event) {
        log.info(format("{0} clicked", getText()));
    }
}
