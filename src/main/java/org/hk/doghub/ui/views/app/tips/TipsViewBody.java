package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.hk.doghub.security.AuthenticatedUser;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewBody extends VerticalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-body";

    private final TipsViewBodyListPresentation listPresentation;
    private final TipsViewBodyGridPresentation gridPresentation;

    public TipsViewBody(TipsDataProvider tipsDataProvider, TipsViewState tipsViewState, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        listPresentation = new TipsViewBodyListPresentation(tipsDataProvider, authenticatedUser);
        add(listPresentation);

        gridPresentation = new TipsViewBodyGridPresentation(tipsDataProvider, authenticatedUser);
        add(gridPresentation);

        setPresentationType(tipsViewState.getPresentationMode());
        tipsViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(TipsViewPresentationMode presentationMode) {
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

    public void presentationModeChanged(TipsViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
