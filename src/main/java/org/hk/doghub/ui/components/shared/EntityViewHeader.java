package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class EntityViewHeader<T extends NamedEntity & HasThumbnailPicture> extends HorizontalLayout {

    public static final String CLASS_NAME = EntityView.CLASS_NAME + "-header";

    private final EntityViewHeaderInfo<T> info;
    private final EntityViewHeaderActions<T> actions;

    private long selectedEntityId;

    public EntityViewHeader(EntityDataProvider<T> entityDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        info = new EntityViewHeaderInfo<>(entityDataProvider);
        add(info);

        actions = new EntityViewHeaderActions<>(entityDataProvider);
        add(actions);
    }

    public long getSelectedEntityId() {
        return selectedEntityId;
    }

    public void setSelectedEntityId(long selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }

    public void selectedEntityChanged(long selectedEntityId) {
        setSelectedEntityId(selectedEntityId);
        info.selectedEntityChanged(selectedEntityId);
        actions.selectedEntityChanged(selectedEntityId);
    }

    public void save() {
        selectedEntityChanged(selectedEntityId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
