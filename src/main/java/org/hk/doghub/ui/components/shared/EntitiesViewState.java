package org.hk.doghub.ui.components.shared;

import java.util.ArrayList;
import java.util.List;

import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.GRID;

public abstract class EntitiesViewState {

    private final List<EntitiesViewPresentationModeChangeListener> presentationModeChangeListeners = new ArrayList<>();

    private EntitiesViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(EntitiesViewPresentationModeChangeListener listener) {
        presentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(EntitiesViewPresentationModeChangeListener listener) {
        presentationModeChangeListeners.remove(listener);
    }

    public EntitiesViewPresentationMode getPresentationMode() {
        return presentationMode;
    }

    public void setPresentationMode(EntitiesViewPresentationMode presentationMode) {
        if(presentationMode != this.presentationMode) {
            fireUsersViewPresentationModeChangeEvent(new EntitiesViewPresentationModeChangeEvent(this.presentationMode, presentationMode));
        }
        this.presentationMode = presentationMode;
    }

    private void fireUsersViewPresentationModeChangeEvent(EntitiesViewPresentationModeChangeEvent event) {
        for(EntitiesViewPresentationModeChangeListener listener : presentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
