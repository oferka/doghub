package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBodyListPresentation extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-list-presentation";

    private final TipsList tipsList;

    public TipsViewBodyListPresentation(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        tipsList = new TipsList(tipsDataProvider, authenticatedUser);
        addAndExpand(tipsList);
    }
}
