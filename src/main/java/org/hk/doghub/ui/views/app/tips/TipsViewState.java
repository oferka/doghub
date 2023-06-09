package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeListener;

import java.util.ArrayList;
import java.util.List;

import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.GRID;

@SpringComponent
@UIScope
public class TipsViewState {

    private final List<EntitiesViewPresentationModeChangeListener> entitiesViewPresentationModeChangeListeners = new ArrayList<>();

    private EntitiesViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(EntitiesViewPresentationModeChangeListener listener) {
        entitiesViewPresentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(EntitiesViewPresentationModeChangeListener listener) {
        entitiesViewPresentationModeChangeListeners.remove(listener);
    }

    public EntitiesViewPresentationMode getPresentationMode() {
        return presentationMode;
    }

    public void setPresentationMode(EntitiesViewPresentationMode presentationMode) {
        if(presentationMode != this.presentationMode) {
            fireTipsViewPresentationModeChangeEvent(new EntitiesViewPresentationModeChangeEvent(this.presentationMode, presentationMode));
        }
        this.presentationMode = presentationMode;
    }

    private void fireTipsViewPresentationModeChangeEvent(EntitiesViewPresentationModeChangeEvent event) {
        for(EntitiesViewPresentationModeChangeListener listener : entitiesViewPresentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
