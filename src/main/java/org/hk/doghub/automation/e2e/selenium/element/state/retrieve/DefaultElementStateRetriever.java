package org.hk.doghub.automation.e2e.selenium.element.state.retrieve;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.element.display.status.ElementDisplayStatusRetriever;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultElementStateRetriever implements ElementStateRetriever {

    private final ElementDisplayStatusRetriever elementDisplayStatusRetriever;

    private @NotNull ElementState get(@NotNull WebDriver webDriver, @NotNull By parentLocator, @NotNull @NotEmpty List<@NotNull ElementState> elementStates, long timeOutInSeconds, boolean highlightIndicatorElement) {
        log.info("Retrieve element state started. Number of provided states is {} and timeout is {} seconds", elementStates.size(), timeOutInSeconds);
        ElementState result = null;
        try {
            ExpectedCondition<Boolean> expectedCondition = ExpectedConditions.or(
                    generateExpectedConditions(
                            parentLocator,
                            elementStates
                    ).toArray(new ExpectedCondition[0])
            );
            boolean expectedConditionSatisfied = new WebDriverWait(
                    webDriver,
                    Duration.ofSeconds(timeOutInSeconds))
                    .until(expectedCondition);
            if (expectedConditionSatisfied) {
                log.debug("Retrieve element state expected condition was satisfied");
                for (ElementState elementState : elementStates) {
                    if (elementDisplayStatusRetriever.isDisplayed(
                            webDriver,
                            parentLocator,
                            elementState.getIndicatorLocator(),
                            highlightIndicatorElement
                    )) {
                        result = elementState;
                        break;
                    }
                }
            }
            else {
                log.debug("Retrieve element state expected condition was not satisfied after waiting {} seconds", timeOutInSeconds);
            }
        }
        catch (Exception e) {
            log.debug("Expected condition failed. Error message was '{}'", e.getMessage());
        }
        if(result == null) {
            log.info("Retrieve element state completed. Result is 'null (non of the provided states was found valid)'");
            throw new StateNotFoundException("Non of the provided steps was found valid");
        }
        log.info("Retrieve element state completed. Result is '{}'", result.getName());
        return result;
    }

    @Override
    public @NotNull ElementState get(@NotNull WebDriver webDriver, @NotNull By parentLocator, @NotNull @NotEmpty List<@NotNull ElementState> elementStates, long timeOutInSeconds) {
        return get(webDriver, parentLocator, elementStates, timeOutInSeconds, false);
    }

    @Override
    public @NotNull ElementState get(@NotNull WebDriver webDriver, @NotNull @NotEmpty List<@NotNull ElementState> elementStates, long timeOutInSeconds, boolean highlightIndicatorElement) {
        log.info(
                "Retrieve element state started. Number of provided states is {} and timeout is {} seconds",
                elementStates.size(),
                timeOutInSeconds
        );
        ElementState result = null;
        try {
            ExpectedCondition<Boolean> expectedCondition = ExpectedConditions.or(
                    generateExpectedConditions(
                            elementStates
                    ).toArray(new ExpectedCondition[0])
            );
            boolean expectedConditionSatisfied = new WebDriverWait(
                    webDriver,
                    Duration.ofSeconds(timeOutInSeconds))
                    .until(expectedCondition);
            if (expectedConditionSatisfied) {
                log.info("Retrieve element state expected condition was satisfied");
                for (ElementState elementState : elementStates) {
                    if (elementDisplayStatusRetriever.isDisplayed(
                            webDriver,
                            elementState.getIndicatorLocator(),
                            highlightIndicatorElement
                    )) {
                        result = elementState;
                        break;
                    }
                }
            }
            else {
                log.debug("Retrieve element state expected condition was not satisfied after waiting {} seconds", timeOutInSeconds);
            }
        }
        catch (Exception e) {
            log.debug("Expected condition failed. Error message was '{}'", e.getMessage());
        }
        if(result == null) {
            log.info("Retrieve element state completed. Result is 'null (non of the provided states was found valid)'");
            throw new StateNotFoundException("Non of the provided steps was found valid");
        }
        log.info("Retrieve element state completed. Result is '{}'", result.getName());
        return result;
    }

    private @NotNull List<ExpectedCondition<WebElement>> generateExpectedConditions(@NotNull By parentLocator, @NotNull List<@NotNull ElementState> elementStates) {
        List<ExpectedCondition<WebElement>> result = new ArrayList<>();
        for(ElementState elementState : elementStates) {
            result.add(ExpectedConditions.presenceOfNestedElementLocatedBy(
                    parentLocator,
                    elementState.getIndicatorLocator()
            ));
        }
        return result;
    }

    private @NotNull List<ExpectedCondition<WebElement>> generateExpectedConditions(@NotNull List<@NotNull ElementState> elementStates) {
        List<ExpectedCondition<WebElement>> result = new ArrayList<>();
        for(ElementState elementState : elementStates) {
            result.add(ExpectedConditions.presenceOfElementLocated(
                    elementState.getIndicatorLocator()
            ));
        }
        return result;
    }
}
