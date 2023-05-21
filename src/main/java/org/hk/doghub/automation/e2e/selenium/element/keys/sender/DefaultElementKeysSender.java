package org.hk.doghub.automation.e2e.selenium.element.keys.sender;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.automation.e2e.selenium.ui.actions.text.input.TextInputSoundPlayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultElementKeysSender implements ElementKeysSender {

    private final TextInputSoundPlayer textInputSoundPlayer;

    @Override
    public void send(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String keys) {
        send(webDriver, element, keys, false);
    }

    @Override
    public void send(@NotNull WebDriver webDriver, @NotNull WebElement element, @NotNull String keys, boolean oneByOne) {
        log.info("Send text '{}' to element with one by one set to '{}' started", keys, oneByOne);
        if(oneByOne) {
            for(int i=0; i<keys.length(); i++) {
                element.sendKeys(String.valueOf(keys.charAt(i)));
                textInputSoundPlayer.playSingleCharacters();
            }
        }
        else {
            element.sendKeys(keys);
            textInputSoundPlayer.playMultipleCharacters();
        }
        log.info("Send text '{}' to element with one by one set to '{}' completed", keys, oneByOne);
    }
}
