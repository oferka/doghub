package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderInfoTitleAvatar;
import org.hk.doghub.ui.components.shared.EntityViewHeaderInfoTitleText;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipViewHeaderInfo.CLASS_NAME + "-title";

    private final EntityViewHeaderInfoTitleAvatar<DogHubTip> avatar;
    private final EntityViewHeaderInfoTitleText<DogHubTip> text;

    public TipViewHeaderInfoTitle(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        avatar = new EntityViewHeaderInfoTitleAvatar<>(tipDataProvider);
        add(avatar);

        text = new EntityViewHeaderInfoTitleText<>(tipDataProvider);
        add(text);

        setVerticalComponentAlignment(CENTER, avatar, text);
    }

    public void selectedTipChanged(long selectedTipId) {
        avatar.selectedEntityChanged(selectedTipId);
        text.selectedEntityChanged(selectedTipId);
    }
}
