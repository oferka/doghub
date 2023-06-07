package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesRouterLink;
import org.hk.doghub.ui.components.shared.NextEntityRouterLink;
import org.hk.doghub.ui.components.shared.PreviousEntityRouterLink;
import org.hk.doghub.ui.views.app.tips.TipDataProvider;
import org.hk.doghub.ui.views.app.tips.TipsView;

@Slf4j
public class TipViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-footer";

    private final PreviousEntityRouterLink previous;

    private final EntitiesRouterLink entities;

    private final NextEntityRouterLink next;

    private long selectedTipId;

    public TipViewFooter(TipDataProvider tipDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setJustifyContentMode(JustifyContentMode.CENTER);

        previous = new PreviousEntityRouterLink(tipDataProvider, authenticatedUser, "Tip", TipView.class);
        add(previous);

        entities = new EntitiesRouterLink(TipsView.class, "Tips");
        add(entities);

        next = new NextEntityRouterLink(tipDataProvider, authenticatedUser, "Tip", TipView.class);
        add(next);
    }

    public long getSelectedTipId() {
        return selectedTipId;
    }

    public void setSelectedTipId(long selectedTipId) {
        this.selectedTipId = selectedTipId;
    }

    public void selectedTipChanged(long selectedTipId) {
        setSelectedTipId(selectedTipId);
        next.selectedEntityChanged(selectedTipId);
        previous.selectedEntityChanged(selectedTipId);
    }

    public void save() {
        selectedTipChanged(selectedTipId);
    }

    public void cancel() {
        log.info("Cancel");
    }
}
