package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityViewHeaderInfoTitle<T extends NamedEntity & HasThumbnailPicture> extends HorizontalLayout {

    public static final String CLASS_NAME = EntityViewHeaderInfo.CLASS_NAME + "-title";

    private final EntityViewHeaderInfoTitleAvatar<T> avatar;
    private final EntityViewHeaderInfoTitleText<T> text;

    public EntityViewHeaderInfoTitle(EntityDataProvider<T> entityDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        avatar = new EntityViewHeaderInfoTitleAvatar<>(entityDataProvider);
        add(avatar);

        text = new EntityViewHeaderInfoTitleText<>(entityDataProvider);
        add(text);

        setVerticalComponentAlignment(CENTER, avatar, text);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        avatar.selectedEntityChanged(selectedEntityId);
        text.selectedEntityChanged(selectedEntityId);
    }
}
