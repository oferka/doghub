package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleCount;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleIcon;
import org.hk.doghub.ui.components.shared.EntitiesViewHeaderInfoTitleText;

import static com.vaadin.flow.component.icon.VaadinIcon.LINK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class TipsViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = TipsViewHeaderInfo.CLASS_NAME + "-title";

    private final EntitiesViewHeaderInfoTitleIcon icon;
    private final EntitiesViewHeaderInfoTitleText text;
    private final EntitiesViewHeaderInfoTitleCount count;

    public TipsViewHeaderInfoTitle(long entityCount) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        icon = new EntitiesViewHeaderInfoTitleIcon(LINK);
        add(icon);

        text = new EntitiesViewHeaderInfoTitleText(TipsView.NAME);
        add(text);

        count = new EntitiesViewHeaderInfoTitleCount(entityCount);
        add(count);
    }
}
