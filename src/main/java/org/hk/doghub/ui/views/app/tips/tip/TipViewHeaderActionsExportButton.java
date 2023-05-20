package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.Key.KEY_E;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;

public class TipViewHeaderActionsExportButton extends Button {

    public static final String CLASS_NAME = TipViewHeaderActions.CLASS_NAME + "-export-button";

    private final TipsDataProvider tipsDataProvider;
    private long selectedTipId;

    public TipViewHeaderActionsExportButton(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        this.tipsDataProvider = tipsDataProvider;
        addClassName(CLASS_NAME);

        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
        addClickShortcut(KEY_E, ALT);
    }

    private void exportClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<DogHubTip> tip = tipsDataProvider.findById(selectedTipId);
        if(tip.isPresent()) {
            name = tip.get().getName();
        }
        Notification.show("Export clicked. Selected tip name is: " + name, 3000, MIDDLE);
    }

    public void selectedTipChanged(long selectedTipId) {
        this.selectedTipId = selectedTipId;
    }
}
