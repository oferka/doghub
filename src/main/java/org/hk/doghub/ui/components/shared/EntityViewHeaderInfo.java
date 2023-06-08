package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntityViewHeaderInfo<T extends NamedEntity & HasThumbnailPicture> extends VerticalLayout {

    public static final String CLASS_NAME = EntityViewHeader.CLASS_NAME + "-info";

    private final EntityViewHeaderInfoTitle<T> title;
    private final EntityViewHeaderInfoDescription<T> description;

    public EntityViewHeaderInfo(EntityDataProvider<T> entityDataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        title = new EntityViewHeaderInfoTitle<>(entityDataProvider);
        add(title);

        description = new EntityViewHeaderInfoDescription<>(entityDataProvider);
        add(description);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        title.selectedEntityChanged(selectedEntityId);
        description.selectedEntityChanged(selectedEntityId);
    }
}
