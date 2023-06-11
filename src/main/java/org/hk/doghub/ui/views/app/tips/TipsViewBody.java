package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.model.tip.DogHubTip;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyGridPresentation;
import org.hk.doghub.ui.components.shared.EntitiesViewBodyListPresentation;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationMode;
import org.hk.doghub.ui.components.shared.EntitiesViewPresentationModeChangeEvent;
import org.hk.doghub.ui.views.app.tips.tip.TipView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-body";

    private final EntitiesViewBodyListPresentation<DogHubTip> listPresentation;
    private final EntitiesViewBodyGridPresentation<DogHubTip, TipView> gridPresentation;

    public TipsViewBody(TipDataProvider tipDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        listPresentation = new EntitiesViewBodyListPresentation<>(new TipsList(tipDataProvider, authenticatedUser));
        add(listPresentation);

        gridPresentation = new EntitiesViewBodyGridPresentation<>(new TipsGrid(tipDataProvider, authenticatedUser));
        add(gridPresentation);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(EntitiesViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(listPresentation);
                add(gridPresentation);
                break;
            case LIST:
                remove(gridPresentation);
                add(listPresentation);
                break;
        }
    }

    public void presentationModeChanged(EntitiesViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
