package org.hk.doghub.ui.views.app.tips.create;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.ui.components.shared.EntityCreationViewHeaderInfoTitle;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipCreationViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipCreationViewHeader.CLASS_NAME + "-info";

    public TipCreationViewHeaderInfo() {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);
        EntityCreationViewHeaderInfoTitle title = new EntityCreationViewHeaderInfoTitle(LINK, "Create a Tip");
        TipCreationViewHeaderInfoDescription description = new TipCreationViewHeaderInfoDescription();
        add(title, description);
    }
}
