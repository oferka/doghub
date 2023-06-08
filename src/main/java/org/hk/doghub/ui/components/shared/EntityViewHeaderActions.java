package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class EntityViewHeaderActions<T extends NamedEntity> extends HorizontalLayout {

    public static final String CLASS_NAME = EntityViewHeader.CLASS_NAME + "-actions";

    private final EntityViewHeaderActionsShareButton<T> share;
    private final EntityViewHeaderActionsExportButton<T> export;

    public EntityViewHeaderActions(EntityDataProvider<T> entityDataProvider) {
        addClassName(CLASS_NAME);

        share = new EntityViewHeaderActionsShareButton<>(entityDataProvider);
        add(share);

        export = new EntityViewHeaderActionsExportButton<>(entityDataProvider);
        add(export);
    }

    public void selectedEntityChanged(long selectedEntityId) {
        share.selectedEntityChanged(selectedEntityId);
        export.selectedEntityChanged(selectedEntityId);
    }
}
