package org.hk.doghub.automation.e2e.selenium.info.screenshot;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultScreenshotExecutor implements ScreenshotExecutor {

    private final ScreenshotExecutorConfiguration screenshotExecutorConfiguration;

    private final ScreenshotSoundPlayer screenshotSoundPlayer;

    @Override
    public void execute(@NotNull WebDriver webDriver) {
        execute(webDriver, true);
    }

    @Override
    public void execute(@NotNull WebDriver webDriver, boolean condition) {
        if(condition) {
            log.info("Take screenshot started");
            if (screenshotExecutorConfiguration.isEnabled()) {
                screenshotSoundPlayer.play();
                Screenshot screenshot = new AShot().takeScreenshot(webDriver);
                File destinationFile = getDestinationFile();
                try {
                    ImageIO.write(screenshot.getImage(), "png", destinationFile);
                }
                catch (IOException e) {
                    log.error("Failed to take screenshot", e);
                }
            }
            else {
                log.info("Screenshot execution is not enabled");
            }
            log.info("Take screenshot completed");
        }
    }

    private File getDestinationFile() {
        log.info("Get destination file started");
        File directory = new File("./target/screenshots");
        if(!directory.exists()) {
            boolean directoryCreated = directory.mkdirs();
            if(directoryCreated) {
                log.info("Directory with path '{}' was successfully created", directory.getPath());
            }
            else {
                log.error("Failed to create directory with path '{}'", directory.getPath());
            }
        }
        String fileName = format("%s.png", currentTimeMillis());
        File result = new File(directory, fileName);
        log.info("Get destination file completed. Result file path is: '{}'", result.getPath());
        return result;
    }
}
