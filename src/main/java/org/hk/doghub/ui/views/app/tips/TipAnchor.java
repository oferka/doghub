package org.hk.doghub.ui.views.app.tips;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.shared.Tooltip;
import org.hk.doghub.model.tip.DogHubTip;

import static com.vaadin.flow.component.html.AnchorTarget.BLANK;
import static java.lang.String.format;
import static org.vaadin.lineawesome.LineAwesomeIcon.EXTERNAL_LINK_ALT_SOLID;

public class TipAnchor extends Anchor {

    public static final String CLASS_NAME = "tip-anchor";

    public TipAnchor(DogHubTip tip) {
        addClassName(CLASS_NAME);
        String moreInfo = tip.getMoreInfo();
        if(moreInfo != null) {
            setHref(format("https://www.%s", tip.getMoreInfo()));
            Component externalLinkIcon = EXTERNAL_LINK_ALT_SOLID.create();
            externalLinkIcon.addClassName(format("%s-icon", CLASS_NAME));
            Tooltip.forComponent(externalLinkIcon).setText("Open link in a new tab");
            add(externalLinkIcon);
            setTarget(BLANK);
        }
    }
}
