package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.ArrayList;
import java.util.List;

import static org.hk.doghub.ui.views.app.tips.TipsViewPresentationMode.GRID;

@SpringComponent
@UIScope
public class TipsViewState {

    private final List<TipsViewPresentationModeChangeListener> tipsViewPresentationModeChangeListeners = new ArrayList<>();

    private TipsViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(TipsViewPresentationModeChangeListener listener) {
        tipsViewPresentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(TipsViewPresentationModeChangeListener listener) {
        tipsViewPresentationModeChangeListeners.remove(listener);
    }

    public TipsViewPresentationMode getPresentationMode() {
        return presentationMode;
    }

    public void setPresentationMode(TipsViewPresentationMode presentationMode) {
        if(presentationMode != this.presentationMode) {
            fireTipsViewPresentationModeChangeEvent(new TipsViewPresentationModeChangeEvent(this.presentationMode, presentationMode));
        }
        this.presentationMode = presentationMode;
    }

    private void fireTipsViewPresentationModeChangeEvent(TipsViewPresentationModeChangeEvent event) {
        for(TipsViewPresentationModeChangeListener listener : tipsViewPresentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
