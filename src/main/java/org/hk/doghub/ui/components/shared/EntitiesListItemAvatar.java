package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.html.Div;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

public class EntitiesListItemAvatar<T extends NamedEntity & HasThumbnailPicture> extends Div {

    public static final String CLASS_NAME = "entities-list-item-avatar";

    private final EntityAvatar<T> avatar;

    public EntitiesListItemAvatar(T entity) {
        addClassNames(CLASS_NAME);
        avatar = new EntityAvatar<>(entity);
        add(avatar);
    }
}
