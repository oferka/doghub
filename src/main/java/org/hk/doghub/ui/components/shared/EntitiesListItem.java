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

    public EntitiesListItem(T entity, List<Component> components, Class<? extends C> entityClass) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");
        EntitiesListItemAvatar<T> avatar = new EntitiesListItemAvatar<>(entity);
        EntitiesListItemInfo<T, C> info = new EntitiesListItemInfo<>(entity, components, entityClass);
        add(avatar, info);
    }
}
