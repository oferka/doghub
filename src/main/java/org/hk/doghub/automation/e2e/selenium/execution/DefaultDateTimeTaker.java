package org.hk.doghub.automation.e2e.selenium.execution;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.time.LocalDateTime.now;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultDateTimeTaker implements DateTimeTaker {

    @Override
    public @NotNull LocalDateTime take() {
        return now(ZoneOffset.UTC);
    }
}
