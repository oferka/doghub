package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

import java.util.List;

public class EntitiesListItem<T extends NamedEntity & HasThumbnailPicture & HasFeedback, C extends Component & HasUrlParameter<Long>> extends HorizontalLayout {

    public static final String CLASS_NAME = "entities-list-item";

    private final EntitiesListItemAvatar<T> avatar;
    private final EntitiesListItemInfo<T, C> info;

    public EntitiesListItem(T entity, List<Component> components, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        avatar = new EntitiesListItemAvatar<>(entity);
        info = new EntitiesListItemInfo<>(entity, components, entityClass);
        add(avatar, info);
    }
}
