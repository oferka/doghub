package org.hk.doghub.ui.views.site;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.ui.views.site.adoption.AdoptionView;
import org.hk.doghub.ui.views.site.beauty.BeautyView;
import org.hk.doghub.ui.views.site.health.HealthView;
import org.hk.doghub.ui.views.site.home.SiteHomeView;
import org.hk.doghub.ui.views.site.knowledge.KnowledgeView;
import org.hk.doghub.ui.views.site.playdate.PlaydateView;
import org.hk.doghub.ui.views.site.safety.SafetyView;
import org.hk.doghub.ui.views.site.social.SocialView;
import org.hk.doghub.ui.views.site.store.StoreView;
import org.hk.doghub.ui.views.site.training.TrainingView;

import java.util.Optional;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.HORIZONTAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_CENTERED;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;

@Slf4j
public class DogHubSiteLayoutTabs extends Tabs {

    public static final String CLASS_NAME = DogHubSiteLayout.ID + "-tabs";

    public DogHubSiteLayoutTabs() {
        addClassName(CLASS_NAME);
        setOrientation(HORIZONTAL);
        addThemeVariants(LUMO_CENTERED, LUMO_MINIMAL);
        add(createTabs());
    }

    private Tab[] createTabs() {
        return new Tab[] {
                new DogHubSiteLayoutTab(SiteHomeView.NAME, SiteHomeView.class),
                new DogHubSiteLayoutTab(AdoptionView.NAME, AdoptionView.class),
                new DogHubSiteLayoutTab(TrainingView.NAME, TrainingView.class),
                new DogHubSiteLayoutTab(HealthView.NAME, HealthView.class),
                new DogHubSiteLayoutTab(BeautyView.NAME, BeautyView.class),
                new DogHubSiteLayoutTab(PlaydateView.NAME, PlaydateView.class),
                new DogHubSiteLayoutTab(StoreView.NAME, StoreView.class),
                new DogHubSiteLayoutTab(SocialView.NAME, SocialView.class),
                new DogHubSiteLayoutTab(SafetyView.NAME, SafetyView.class),
                new DogHubSiteLayoutTab(KnowledgeView.NAME, KnowledgeView.class)
        };
    }

    public void presentTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
        log.info("Present tab: {}", ((DogHubSiteLayoutTab)getSelectedTab()).getText());
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}
