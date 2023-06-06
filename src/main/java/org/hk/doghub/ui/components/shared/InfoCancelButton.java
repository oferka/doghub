package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class InfoCancelButton extends Button {

    public static final String CLASS_NAME = "info-cancel-button";

    private final List<InfoCancelListener> infoCancelListeners = new ArrayList<>();

    public InfoCancelButton() {
        addClassName(CLASS_NAME);
        setText("Cancel");
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cancelClicked);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        infoCancelListeners.add(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        infoCancelListeners.remove(listener);
    }

    private void cancelClicked(ClickEvent<Button> event) {
        fireInfoCancelEvent(new InfoCancelEvent(this));
    }

    private void fireInfoCancelEvent(InfoCancelEvent event) {
        for(InfoCancelListener listener : infoCancelListeners) {
            listener.cancelTriggered(event);
        }
    }
}
