package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesList;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBodyListPresentation extends VerticalLayout {

    public static final String CLASS_NAME = TipsViewBody.CLASS_NAME + "-list-presentation";

    private final EntitiesList<DogHubTip> list;

    public TipsViewBodyListPresentation(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        list = new TipsList(tipDataProvider, authenticatedUser);
        addAndExpand(list);
    }
}
