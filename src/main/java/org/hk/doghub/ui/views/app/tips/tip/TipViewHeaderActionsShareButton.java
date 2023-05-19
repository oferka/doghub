package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.Key.KEY_S;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class TipViewHeaderActionsShareButton extends Button {

    public static final String CLASS_NAME = TipViewHeaderActions.CLASS_NAME + "-share-button";

    private final TipsDataProvider tipsDataProvider;
    private long selectedTipId;

    public TipViewHeaderActionsShareButton(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);

        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(KEY_S, ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        if(tip.isPresent()) {
            name = tip.get().getName();
        }
        Notification.show("Share clicked. Selected tip name is: " + name, 3000, MIDDLE);
    }

    public void selectedTipChanged(long selectedTipId) {
        this.selectedTipId = selectedTipId;
    }
}
