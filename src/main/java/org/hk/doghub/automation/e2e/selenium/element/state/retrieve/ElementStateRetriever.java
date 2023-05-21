package org.hk.doghub.automation.e2e.selenium.element.state.retrieve;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface ElementStateRetriever {

    @NotNull ElementState get(@NotNull WebDriver webDriver, @NotNull By parentLocator, @NotNull @NotEmpty List<@NotNull ElementState> elementStates, long timeOutInSeconds);

    @NotNull ElementState get(@NotNull WebDriver webDriver, @NotNull @NotEmpty List<@NotNull ElementState> elementStates, long timeOutInSeconds, boolean highlightIndicatorElement);
}
