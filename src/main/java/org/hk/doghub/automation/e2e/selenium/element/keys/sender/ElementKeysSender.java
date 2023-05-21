package org.hk.doghub.automation.e2e.selenium.element.keys.sender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementKeysSender {

    void send(@NotNull WebDriver driver, @NotNull WebElement element, @NotNull @NotBlank String keys);

    void send(@NotNull WebDriver driver, @NotNull WebElement element, @NotNull @NotBlank String keys, boolean oneByOne);
}
