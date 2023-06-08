package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoContainerButtons;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.EntityDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipInfoContainer extends VerticalLayout {

    public static final String CLASS_NAME = "tip-info-container";

    private final EntityDataProvider<DogHubTip> entityDataProvider;

    private final EntityInfoContainerForm<DogHubTip, TipUpdateParameters> form;

    private final InfoContainerButtons buttons;

    public TipInfoContainer(EntityDataProvider<DogHubTip> entityDataProvider, TipUpdateService tipUpdateService) {
        this.entityDataProvider = entityDataProvider;
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        form = new TipInfoContainerForm(entityDataProvider, tipUpdateService);
        add(form);

        buttons = new InfoContainerButtons();
        add(buttons);
    }

    public void setTip(long tipId) {
        Optional<DogHubTip> tipOptional = entityDataProvider.findById(tipId);
        tipOptional.ifPresent(form::setValue);
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
