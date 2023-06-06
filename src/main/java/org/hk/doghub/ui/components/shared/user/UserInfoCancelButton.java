package org.hk.doghub.ui.components.shared.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.ui.components.shared.InfoCancelEvent;
import org.hk.doghub.ui.components.shared.InfoCancelListener;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class UserInfoCancelButton extends Button {

    public static final String CLASS_NAME = UserInfoContainerButtons.CLASS_NAME + "-cancel";

    private final List<InfoCancelListener> infoCancelListeners = new ArrayList<>();

    public UserInfoCancelButton() {
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
