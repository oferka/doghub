package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewBodyListPresentation<T extends NamedEntity & HasThumbnailPicture & HasFeedback> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view-body-list-presentation";

    public EntitiesViewBodyListPresentation(EntitiesList<T> list) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        addAndExpand(list);
    }
}
