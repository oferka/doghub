package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-body";

    private final TipsViewBodyListPresentation tipsViewBodyListPresentation;
    private final TipsViewBodyGridPresentation tipsViewBodyGridPresentation;

    public TipsViewBody(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        tipsViewBodyListPresentation = new TipsViewBodyListPresentation(tipsDataProvider, authenticatedUser);
        add(tipsViewBodyListPresentation);

        tipsViewBodyGridPresentation = new TipsViewBodyGridPresentation(tipsDataProvider, authenticatedUser);
        add(tipsViewBodyGridPresentation);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(TipsViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(tipsViewBodyListPresentation);
                add(tipsViewBodyGridPresentation);
                break;
            case LIST:
                remove(tipsViewBodyGridPresentation);
                add(tipsViewBodyListPresentation);
                break;
        }
    }

    public void presentationModeChanged(TipsViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewTipViewPresentationMode());
    }
}
