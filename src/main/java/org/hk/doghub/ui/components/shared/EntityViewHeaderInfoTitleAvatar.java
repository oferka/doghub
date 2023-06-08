package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

public class EntityViewHeaderInfoTitleAvatar<T extends NamedEntity & HasThumbnailPicture> extends HorizontalLayout {

    public static final String CLASS_NAME = EntityViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final EntityAvatar<T> avatar;
    private final EntityDataProvider<T> entityDataProvider;

    public EntityViewHeaderInfoTitleAvatar(EntityDataProvider<T> entityDataProvider) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);
        avatar = new EntityAvatar<>(null);
        add(avatar);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        Optional<T> entity = entityDataProvider.findById(selectedEntityId);
        entity.ifPresent(avatar::selectedEntityChanged);
    }
}
