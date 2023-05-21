package org.hk.doghub.automation.e2e.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.stereotype.Service;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultWebDriverProvider implements WebDriverProvider {

    @Override
    public @NotNull WebDriver get(@Valid @NotNull Browser browser) {
        log.info("Web driver creation started");
        WebDriver driver = switch (browser.getType()) {
            case CHROME -> createChromeDriver(browser);
            case FIREFOX -> createFirefoxDriver(browser);
            case EDGE -> createEdgeDriver(browser);
            case SAFARI -> createSafariDriver(browser);
        };
        if(browser.isMaximize()) {
            maximizeWindow(driver);
        }
        validate(driver);
        log.info("Web driver creation completed");
        return driver;
    }

    private WebDriver createChromeDriver(Browser browser) {
        log.info("Chrome web driver creation started");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if(browser.isHeadless()) {
            chromeOptions.addArguments("--headless=new");
        }
        WebDriver result = new ChromeDriver(chromeOptions);
        log.info("Chrome web driver creation completed");
        return result;
    }

    private WebDriver createFirefoxDriver(Browser browser) {
        log.info("Firefox web driver creation started");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(browser.isHeadless()) {
            firefoxOptions.addArguments("--headless=new");
        }
        WebDriver result = new FirefoxDriver(firefoxOptions);
        log.info("Firefox web driver creation completed");
        return result;
    }

    private WebDriver createEdgeDriver(Browser browser) {
        log.info("Edge web driver creation started");
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        if(browser.isHeadless()) {
            edgeOptions.addArguments("--headless=new");
        }
        WebDriver result = new EdgeDriver(edgeOptions);
        log.info("Edge web driver creation completed");
        return result;
    }

    private WebDriver createSafariDriver(Browser browser) {
        log.info("Safari web driver creation started");
        SafariOptions safariOptions = new SafariOptions();
        WebDriver result = new SafariDriver(safariOptions);
        log.info("Safari web driver creation completed");
        return result;
    }

    private void maximizeWindow(@NotNull WebDriver driver) {
        log.info("Browser window maximize started");
        driver.manage().window().maximize();
        log.info("Browser window maximize completed");
    }

    private void validate(@NotNull WebDriver driver) {
        log.info("Validation for '{}' started", driver);
        Validator validator = buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<WebDriver>> violations = validator.validate(driver);
        if (!violations.isEmpty()) {
            log.error("Validation for '{}' completed with {} violations: {}", driver, violations.size(), violations);
            throw new ConstraintViolationException(violations);
        }
        log.info("Validation for '{}' completed successfully. No constraint violations were found", driver);
    }
}
