package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewFooter extends VerticalLayout {

    public static final String CLASS_NAME = TipsView.CLASS_NAME + "-footer";

    public TipsViewFooter() {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        add(new H2("Tips View Footer"));
    }
}
