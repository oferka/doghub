package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;

import java.util.ArrayList;
import java.util.List;

import static org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode.GRID;

@SpringComponent
@UIScope
public class UsersViewState {

    private final List<UsersViewPresentationModeChangeListener> presentationModeChangeListeners = new ArrayList<>();

    private EntitiesViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
        presentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
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
        for(UsersViewPresentationModeChangeListener listener : presentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
