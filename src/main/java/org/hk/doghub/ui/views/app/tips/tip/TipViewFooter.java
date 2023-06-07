package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityNavigationContainer;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.CENTER;

@Slf4j
public class TipViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-footer";

    private final EntityNavigationContainer<DogHubTip> navigationContainer;

    public TipViewFooter(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(CENTER);

        navigationContainer = new EntityNavigationContainer<>(tipDataProvider, authenticatedUser, TipView.NAME, TipView.class, TipsView.NAME, TipsView.class);
        add(navigationContainer);
    }

    public long getSelectedTipId() {
        return navigationContainer.getSelectedEntityId();
    }

    public void setSelectedTipId(long selectedTipId) {
        navigationContainer.setSelectedEntityId(selectedTipId);
    }

    public void selectedTipChanged(long selectedTipId) {
        navigationContainer.selectedEntityChanged(selectedTipId);
    }

    public void save() {
        navigationContainer.save();
    }

    public void cancel() {
        navigationContainer.cancel();
    }
}
