package org.hk.doghub.ui.components.shared.tip;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import lombok.extern.slf4j.Slf4j;

import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;

@Slf4j
public class TipsButton extends Button {

    public static final String CLASS_NAME = "tips-button";

    public TipsButton() {
        addClassName(CLASS_NAME);
        setIcon(TABLE.create());
        setText("Tips");
        addClickListener(this::tipsClicked);
    }

    private void tipsClicked(ClickEvent<Button> event) {
        log.info("Tips clicked");
    }
}
