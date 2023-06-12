package org.hk.doghub.ui.views.app.tips.tip;

import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.ui.components.shared.EntityInfoContainer;
import org.hk.doghub.ui.components.shared.EntityUpdateService;
import org.hk.doghub.ui.components.shared.EntityViewBody;
import org.hk.doghub.ui.components.shared.tip.TipInfoContainerForm;
import org.hk.doghub.ui.components.shared.tip.TipUpdateParameters;
import org.hk.doghub.ui.views.app.EntityDataProvider;

public class TipViewBody extends EntityViewBody<DogHubTip, TipUpdateParameters> {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-body";

    public TipViewBody(EntityDataProvider<DogHubTip> entityDataProvider, EntityUpdateService<DogHubTip, TipUpdateParameters> entityUpdateService) {
        super(entityDataProvider, entityUpdateService);
        addClassName(CLASS_NAME);
    }

    @Override
    protected EntityInfoContainer<DogHubTip, TipUpdateParameters> getEntityInfo() {
        return new EntityInfoContainer<>(entityDataProvider, new TipInfoContainerForm(entityDataProvider, entityUpdateService));
    }
}
