package org.hk.doghub.ui.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasUrlParameter;
import org.hk.doghub.model.HasFeedback;
import org.hk.doghub.model.HasThumbnailPicture;
import org.hk.doghub.model.NamedEntity;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class EntitiesViewBody<T extends NamedEntity & HasThumbnailPicture & HasFeedback, C extends Component & HasUrlParameter<Long>> extends VerticalLayout {

    public static final String CLASS_NAME = "entities-view-body";

    private final EntitiesViewBodyListPresentation<T> cardPresentation;
    private final EntitiesViewBodyGridPresentation<T, C> gridPresentation;

    public EntitiesViewBody(EntitiesList<T> list, EntitiesGrid<T, C> grid, EntitiesViewState viewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        cardPresentation = new EntitiesViewBodyListPresentation<>(list);
        add(cardPresentation);

        gridPresentation = new EntitiesViewBodyGridPresentation<>(grid);
        add(gridPresentation);

        setPresentationType(viewState.getPresentationMode());
        viewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(EntitiesViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(cardPresentation);
                add(gridPresentation);
                break;
            case LIST:
                remove(gridPresentation);
                add(cardPresentation);
                break;
        }
    }

    public void presentationModeChanged(EntitiesViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewPresentationMode());
    }
}
