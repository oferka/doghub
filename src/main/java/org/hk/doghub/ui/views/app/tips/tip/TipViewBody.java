package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.tip.TipInfoCancelListener;
import org.hk.doghub.ui.components.shared.tip.TipInfoContainer;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-body";

    private final TipInfoContainer tipInfo;

    public TipViewBody(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipInfo = new TipInfoContainer(tipsDataProvider, authenticatedUser, tipCreationService);
        add(tipInfo);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipInfo.setTip(selectedTipId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        tipInfo.addInfoSaveListener(listener);
    }

    public void addTipInfoCancelListener(TipInfoCancelListener listener) {
        tipInfo.addTipInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        tipInfo.removeInfoSaveListener(listener);
    }

    public void removeTipInfoCancelListener(TipInfoCancelListener listener) {
        tipInfo.removeTipInfoCancelListener(listener);
    }

    public void save() {
        tipInfo.save();
    }

    public void cancel() {
        tipInfo.cancel();
    }
}
