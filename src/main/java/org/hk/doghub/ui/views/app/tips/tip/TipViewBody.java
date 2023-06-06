package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.components.shared.tip.TipInfoContainer;
import org.hk.doghub.ui.components.shared.tip.TipUpdateService;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-body";

    private final TipInfoContainer tipInfo;

    public TipViewBody(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser, TipUpdateService tipUpdateService) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipInfo = new TipInfoContainer(tipDataProvider, authenticatedUser, tipUpdateService);
        add(tipInfo);
    }

    public void selectedTipChanged(long selectedTipId) {
        tipInfo.setTip(selectedTipId);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        tipInfo.addInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        tipInfo.addInfoCancelListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        tipInfo.removeInfoSaveListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        tipInfo.removeInfoCancelListener(listener);
    }

    public void save() {
        tipInfo.save();
    }

    public void cancel() {
        tipInfo.cancel();
    }
}
