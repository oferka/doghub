package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

@Slf4j
public class TipViewHeader extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-header";

    private final TipViewHeaderInfo info;
    private final TipViewHeaderActions actions;

    private long selectedTipId;

    public TipViewHeader(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);

        info = new TipViewHeaderInfo(tipsDataProvider, authenticatedUser);
        add(info);

        actions = new TipViewHeaderActions(tipsDataProvider, authenticatedUser);
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
        info.selectedTipChanged(selectedTipId);
        actions.selectedTipChanged(selectedTipId);
    }

    public void save() {
        selectedTipChanged(selectedTipId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
