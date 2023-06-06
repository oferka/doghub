package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.InfoCancelListener;
import org.hk.doghub.ui.components.shared.InfoSaveListener;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;
import org.hk.doghub.ui.views.app.tips.create.TipCreationService;

public class TipInfoContainerButtons extends HorizontalLayout {

    public static final String CLASS_NAME = TipInfoContainer.CLASS_NAME + "-buttons";

    private final TipInfoSaveButton save;

    private final TipInfoCancelButton cancel;

    public TipInfoContainerButtons(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser, TipCreationService tipCreationService) {
        addClassName(CLASS_NAME);

        save = new TipInfoSaveButton();
        add(save);

        cancel = new TipInfoCancelButton();
        add(cancel);
    }

    public void addInfoSaveListener(InfoSaveListener listener) {
        save.addInfoSaveListener(listener);
    }

    public void removeInfoSaveListener(InfoSaveListener listener) {
        save.removeInfoSaveListener(listener);
    }

    public void addInfoCancelListener(InfoCancelListener listener) {
        cancel.addInfoCancelListener(listener);
    }

    public void removeInfoCancelListener(InfoCancelListener listener) {
        cancel.removeInfoCancelListener(listener);
    }
}
