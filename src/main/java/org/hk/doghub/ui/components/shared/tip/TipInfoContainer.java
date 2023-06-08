package org.hk.doghub.ui.components.shared.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.EntityInfoContainerForm;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class TipInfoContainer extends EntityInfoContainer<DogHubTip, TipUpdateParameters> {

    public static final String CLASS_NAME = "tip-info-container";

    public TipInfoContainer(EntityDataProvider<DogHubTip> entityDataProvider, TipUpdateService entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
        addClassName(CLASS_NAME);
    }


    @Override
    protected EntityInfoContainerForm<DogHubTip, TipUpdateParameters> getForm() {
        return new TipInfoContainerForm(entityDataProvider, entityUpdateService);
    }
}
