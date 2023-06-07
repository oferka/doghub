package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntityViewHeaderInfo;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;

@Slf4j
public class TipViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-header";

    private final EntityViewHeaderInfo<DogHubTip> info;
    private final TipViewHeaderActions actions;

    private long selectedTipId;

    public TipViewHeader(TipDataProvider tipDataProvider) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);

        info = new EntityViewHeaderInfo<>(tipDataProvider);
        add(info);

        actions = new TipViewHeaderActions(tipDataProvider);
        add(actions);
    }

    public long getSelectedTipId() {
        return selectedTipId;
    }

    public void setSelectedTipId(long selectedTipId) {
        this.selectedTipId = selectedTipId;
    }

    public void selectedTipChanged(long selectedTipId) {
        setSelectedTipId(selectedTipId);
        info.selectedEntityChanged(selectedTipId);
        actions.selectedTipChanged(selectedTipId);
    }

    public void save() {
        selectedTipChanged(selectedTipId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
