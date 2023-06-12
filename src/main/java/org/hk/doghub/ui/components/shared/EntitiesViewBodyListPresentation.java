package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewBodyListPresentation<T extends NamedEntity & HasThumbnailPicture & HasFeedback, C extends Component & HasUrlParameter<Long>> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view-body-list-presentation";

    public EntitiesViewBodyListPresentation(EntitiesList<T, C> list) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        addAndExpand(list);
    }
}
