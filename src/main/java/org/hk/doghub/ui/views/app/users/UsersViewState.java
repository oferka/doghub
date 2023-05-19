package org.hk.doghub.ui.views.app.users;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.ArrayList;
import java.util.List;

import static org.hk.doghub.ui.views.app.users.UsersViewPresentationMode.GRID;

@SpringComponent
@UIScope
public class UsersViewState {

    private final List<UsersViewPresentationModeChangeListener> usersViewPresentationModeChangeListeners = new ArrayList<>();

    private UsersViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
        usersViewPresentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
        usersViewPresentationModeChangeListeners.remove(listener);
    }

    public UsersViewPresentationMode getPresentationMode() {
        return presentationMode;
    }

    public void setPresentationMode(UsersViewPresentationMode presentationMode) {
        if(presentationMode != this.presentationMode) {
            fireUsersViewPresentationModeChangeEvent(new UsersViewPresentationModeChangeEvent(this.presentationMode, presentationMode));
        }
        this.presentationMode = presentationMode;
    }

    private void fireUsersViewPresentationModeChangeEvent(UsersViewPresentationModeChangeEvent event) {
        for(UsersViewPresentationModeChangeListener listener : usersViewPresentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
