package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import org.hk.doghub.ui.components.shared.InfoCancelEvent;

import java.util.ArrayList;
import java.util.List;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;

public class TipInfoCancelButton extends Button {

    public static final String CLASS_NAME = TipInfoContainerButtons.CLASS_NAME + "-cancel";

    private final List<TipInfoCancelListener> tipInfoCancelListeners = new ArrayList<>();

    public TipInfoCancelButton() {
        addClassName(CLASS_NAME);
        setText("Cancel");
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cancelClicked);
    }

    public void addTipInfoCancelListener(TipInfoCancelListener listener) {
        tipInfoCancelListeners.add(listener);
    }

    public void removeTipInfoCancelListener(TipInfoCancelListener listener) {
        tipInfoCancelListeners.remove(listener);
    }

    private void cancelClicked(ClickEvent<Button> event) {
        fireInfoCancelEvent(new InfoCancelEvent(this));
    }

    private void fireInfoCancelEvent(InfoCancelEvent event) {
        for(TipInfoCancelListener listener : tipInfoCancelListeners) {
            listener.cancelTriggered(event);
        }
    }
}
