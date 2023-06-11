package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoBody;
import org.hk.doghub.ui.components.shared.EntitiesListItemInfoHeader;
import org.hk.doghub.ui.components.shared.FeedbackContainer;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import java.util.Arrays;
import java.util.List;

public class TipsListItemInfo extends VerticalLayout {

    public static final String CLASS_NAME = TipsListItem.CLASS_NAME + "-info";

    private final EntitiesListItemInfoHeader<DogHubTip> header;
    private final EntitiesListItemInfoBody<DogHubTip> body;
    private final FeedbackContainer<DogHubTip> feedback;

    public TipsListItemInfo(DogHubTip tip, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setPadding(false);

        header = new EntitiesListItemInfoHeader<>(tip, TipView.class);
        add(header);

        body = new EntitiesListItemInfoBody<>(tip, getBodyComponents(authenticatedUser));
        add(body);

        feedback = new FeedbackContainer<>(tip);
        add(feedback);
    }

    private List<Component> getBodyComponents(AuthenticatedUser authenticatedUser) {
        List<Component> result = Arrays.asList();
        return result;
    }
}
