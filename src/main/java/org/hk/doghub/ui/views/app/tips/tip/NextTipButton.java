package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.Key.KEY_N;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.ARROW_RIGHT;

@Slf4j
public class NextTipButton extends Button {

    public static final String CLASS_NAME = "next-tip-button";

    public NextTipButton() {
        addClassName(CLASS_NAME);
        setIcon(ARROW_RIGHT.create());
        setIconAfterText(true);
        setText("Next Tip");
        addClickListener(this::nextTipClicked);
        addClickShortcut(KEY_N, ALT);
    }

    private void nextTipClicked(ClickEvent<Button> event) {
        log.info("Next tip clicked");
    }
}
