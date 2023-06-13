package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import java.util.ArrayList;
import java.util.List;

public class EntityCreationButton extends Button {

    public static final String CLASS_NAME = "entity-creation-button";

    private final List<InfoSaveListener> infoSaveListeners = new ArrayList<>();

    public EntityCreationButton() {
        addClassName(CLASS_NAME);
        setText("Continue");
        addClickListener(this::clicked);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        infoSaveListeners.add(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        infoSaveListeners.remove(listener);
    }

    private void clicked(ClickEvent<Button> event) {
        fireInfoSaveEvent(new InfoSaveEvent(this));
    }

    private void fireInfoSaveEvent(InfoSaveEvent event) {
        for(InfoSaveListener listener : infoSaveListeners) {
            listener.saveTriggered(event);
        }
    }
}
