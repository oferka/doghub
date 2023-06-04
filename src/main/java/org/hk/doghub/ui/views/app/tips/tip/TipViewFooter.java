package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.tip.TipsRouterLink;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

@Slf4j
public class TipViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-footer";

    private final PreviousTipRouterLink previous;

    private final TipsRouterLink tips;

//    private final NextTipRouterLink next;

    private long selectedTipId;

    public TipViewFooter(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);

        previous = new PreviousTipRouterLink(tipsDataProvider, authenticatedUser);
        add(previous);

        tips = new TipsRouterLink();
        add(tips);

//        next = new NextTipRouterLink(tipsDataProvider, authenticatedUser);
//        add(next);
    }

    public long getSelectedTipId() {
        return selectedTipId;
    }

    public void setSelectedTipId(long selectedTipId) {
        this.selectedTipId = selectedTipId;
    }

    public void selectedTipChanged(long selectedTipId) {
        setSelectedTipId(selectedTipId);
//        next.selectedTipChanged(selectedTipId);
        previous.selectedTipChanged(selectedTipId);
    }

    public void save() {
        selectedTipChanged(selectedTipId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
