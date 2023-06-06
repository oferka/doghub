package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoContainerButtons;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "tip-info-container";

    private final TipDataProvider tipDataProvider;

    private final TipInfoContainerForm form;

    private final InfoContainerButtons buttons;

    public TipInfoContainer(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        this.tipDataProvider = tipDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        form = new TipInfoContainerForm(tipDataProvider, tipCreationService);
        add(form);

        buttons = new InfoContainerButtons();
        add(buttons);
    }

    public void setTip(long tipId) {
        Optional<DogHubTip> tipOptional = tipDataProvider.findById(tipId);
        tipOptional.ifPresent(form::setTip);
    }

    public void save() {
        form.save();
    }

    public void cancel() {
        form.cancel();
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        buttons.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        buttons.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        buttons.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        buttons.removeInfoCancelListener(listener);
    }
}
