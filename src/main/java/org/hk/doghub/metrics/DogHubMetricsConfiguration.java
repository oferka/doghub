package org.hk.doghub.metrics;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.service.tip.DogHubTipService;
import org.hk.doghub.data.service.user.DogHubUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import static org.hk.doghub.metrics.TagUtils.getCommonTags;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
@RequiredArgsConstructor
public class DogHubMetricsConfiguration {

    private final MeterRegistry registry;

    private final Environment environment;

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }

    @Bean
    CommandLineRunner addDogHubUserEntityCountGauge(DogHubUserService dogHubUserService) {
        return args -> Gauge.builder("doghub_user_entity_count", dogHubUserService::count).register(registry);
    }

    @Bean
    CommandLineRunner addDogHubTipEntityCountGauge(DogHubTipService dogHubTipService) {
        return args -> Gauge.builder("doghub_tip_entity_count", dogHubTipService::count).register(registry);
    }

    @Bean
    CommandLineRunner configureMeterRegistry() {
        return args -> registry.config().commonTags(getCommonTags(environment));
    }
}
