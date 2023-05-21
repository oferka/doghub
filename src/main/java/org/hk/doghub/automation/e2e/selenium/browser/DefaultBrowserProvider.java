package org.hk.doghub.automation.e2e.selenium.browser;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultBrowserProvider implements BrowserProvider {

    @NotNull
    private final BrowserConfiguration browserConfiguration;

    @Override
    public @NotNull Browser get() {
        return get(browserConfiguration);
    }

    @Override
    public @NotNull Browser get(BrowserConfiguration configuration) {
        log.info("Get browser with configuration {} started", configuration);
        Browser browser = new Browser(
                configuration.getType(),
                configuration.isMaximizeWindow(),
                configuration.isHeadless()
        );
        validate(browser);
        log.info("Get browser with configuration {} completed", configuration);
        return browser;
    }

    private void validate(@NotNull Browser browser) {
        log.info("Validation for '{}' started", browser);
        Validator validator = buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Browser>> violations = validator.validate(browser);
        if (!violations.isEmpty()) {
            log.error("Validation for '{}' completed with {} violations: {}", browser, violations.size(), violations);
            throw new ConstraintViolationException(violations);
        }
        log.info("Validation for '{}' completed successfully. No constraint violations were found", browser);
    }
}
