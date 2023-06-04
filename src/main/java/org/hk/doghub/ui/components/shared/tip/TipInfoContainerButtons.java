package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

public class TipInfoContainerButtons extends HorizontalLayout {

    public static final String CLASS_NAME = TipInfoContainer.CLASS_NAME + "-buttons";

    private final TipInfoSaveButton save;

    private final TipInfoCancelButton cancel;

    public TipInfoContainerButtons(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        save = new TipInfoSaveButton(tipsDataProvider, authenticatedUser, tipCreationService);
        add(save);

        cancel = new TipInfoCancelButton();
        add(cancel);
    }

    public void addTipInfoSaveListener(TipInfoSaveListener listener) {
        save.addTipInfoSaveListener(listener);
    }

    public void removeTipInfoSaveListener(TipInfoSaveListener listener) {
        save.removeTipInfoSaveListener(listener);
    }

    public void addTipInfoCancelListener(TipInfoCancelListener listener) {
        cancel.addTipInfoCancelListener(listener);
    }

    public void removeTipInfoCancelListener(TipInfoCancelListener listener) {
        cancel.removeTipInfoCancelListener(listener);
    }
}
