package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_P;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_LEFT;

@Slf4j
public class PreviousTipButton extends Button {

    public static final String CLASS_NAME = "previous-tip-button";

    public PreviousTipButton() {
        addClassName(CLASS_NAME);
        setIcon(ARROW_LEFT.create());
        setText("Previous Tip");
        addClickListener(this::previousTipClicked);
        addClickShortcut(KEY_P, ALT);
    }

    private void previousTipClicked(ClickEvent<Button> event) {
        log.info("Previous tip clicked");
    }
}
