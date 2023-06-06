package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.ui.components.shared.InfoSaveEvent;
import org.hk.doghub.ui.components.shared.InfoSaveListener;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class UserInfoSaveButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-save";

    private final List<InfoSaveListener> infoSaveListeners = new ArrayList<>();

    public UserInfoSaveButton() {
        addClassName(CLASS_NAME);
        setText("Save");
        addClickShortcut(KEY_S, ALT);
        addClickListener(this::saveClicked);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        infoSaveListeners.add(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        infoSaveListeners.remove(listener);
    }

    private void saveClicked(ClickEvent<Button> event) {
        fireInfoSaveEvent(new InfoSaveEvent(this));
    }

    private void fireInfoSaveEvent(InfoSaveEvent event) {
        for(InfoSaveListener listener : infoSaveListeners) {
            listener.saveTriggered(event);
        }
    }
}
