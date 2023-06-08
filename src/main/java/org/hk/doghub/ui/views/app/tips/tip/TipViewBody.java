package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.tip.TipInfoContainer;
import org.hk.doghub.ui.components.shared.tip.TipUpdateParameters;
import org.hk.doghub.ui.components.shared.tip.TipUpdateService;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-body";

    private final EntityInfoContainer<DogHubTip, TipUpdateParameters> entityInfo;

    public TipViewBody(TipDataProvider tipDataProvider, TipUpdateService tipUpdateService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        entityInfo = new TipInfoContainer(tipDataProvider, tipUpdateService);
        add(entityInfo);
    }

    public void selectedTipChanged(long selectedTipId) {
        entityInfo.setEntity(selectedTipId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        entityInfo.addInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        entityInfo.addInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        entityInfo.removeInfoSaveListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        entityInfo.removeInfoCancelListener(listener);
    }

    public void save() {
        entityInfo.save();
    }

    public void cancel() {
        entityInfo.cancel();
    }
}
