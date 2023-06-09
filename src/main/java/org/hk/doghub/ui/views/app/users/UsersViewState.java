package org.hk.doghub.ui.views.app.users;

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
public class UsersViewState {

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
