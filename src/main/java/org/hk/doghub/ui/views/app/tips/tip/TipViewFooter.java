package org.hk.doghub.ui.views.app.tips.tip;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.security.AuthenticatedUser;
import org.hk.doghub.ui.views.app.tips.TipsDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipViewFooter extends HorizontalLayout {

    public static final String CLASS_NAME = TipView.CLASS_NAME + "-footer";

    private final H2 label;

    public TipViewFooter(TipsDataProvider tipsDataProvider, AuthenticatedUser authenticatedUser) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        label = new H2("say what again");
        add(label);
    }

    public void selectedTipChanged(long selectedTipId) {
        label.setText("Selected Tip: " + selectedTipId);
    }
}
