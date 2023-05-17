package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.dom.DomEvent;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.DogHubUser;

@Slf4j
public class UserAvatar extends Avatar {

    public static final String CLASS_NAME = "user-avatar";

    public UserAvatar(DogHubUser user) {
        addClassName(CLASS_NAME);
        setUser(user);
        getElement().addEventListener("click", this::avatarClicked);
    }

    public void selectedUserChanged(DogHubUser user) {
        setUser(user);
    }

    public void setUser(DogHubUser user) {
        if(user != null) {
            setImage(user.getThumbnailPicture());
            setName(user.getName());
            Tooltip.forComponent(this).setText(user.getName());
        }
    }

    private void avatarClicked(DomEvent event) {
        log.info("User avatar clicked");
    }
}
