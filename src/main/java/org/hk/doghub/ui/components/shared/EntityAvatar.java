package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.dom.DomEvent;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

@Slf4j
public class EntityAvatar<T extends NamedEntity & HasThumbnailPicture> extends Avatar {

    public static final String CLASS_NAME = "entity-avatar";

    public EntityAvatar(T entity) {
        addClassName(CLASS_NAME);
        setEntity(entity);
        getElement().addEventListener("click", this::avatarClicked);
    }

    public void selectedEntityChanged(T entity) {
        setEntity(entity);
    }

    public void setEntity(T entity) {
        if(entity != null) {
            setImage(entity.getThumbnailPicture());
            setName(entity.getName());
            Tooltip.forComponent(this).setText(entity.getName());
        }
    }

    private void avatarClicked(DomEvent event) {
        log.info("Entity avatar clicked");
    }
}
