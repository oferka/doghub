package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static org.vaadin.lineawesome.LineAwesomeIcon.TABLE_SOLID;

@Slf4j
public class EntitiesButton extends Button {

    public static final String CLASS_NAME = "entities-button";

    public EntitiesButton(String entitiesLabel) {
        addClassName(CLASS_NAME);
        setIcon(TABLE_SOLID.create());
        setText(entitiesLabel);
        addClickListener(this::entitiesClicked);
    }

    private void entitiesClicked(ClickEvent<Button> event) {
        log.info("Entities clicked");
    }
}
