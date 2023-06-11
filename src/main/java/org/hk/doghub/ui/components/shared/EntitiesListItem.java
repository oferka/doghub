package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

import java.util.List;

public class EntitiesListItem<T extends NamedEntity & HasThumbnailPicture & HasFeedback> extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-list-item";

    private final EntitiesListItemAvatar<T> avatar;
    private final EntitiesListItemInfo<T> info;

    public EntitiesListItem(T entity, List<Component> components) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        avatar = new EntitiesListItemAvatar<>(entity);
        info = new EntitiesListItemInfo<>(entity, components);
        add(avatar, info);
    }
}
