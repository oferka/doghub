package org.hk.doghub.automation.e2e.selenium.execution;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public interface DateTimeTaker {

    @NotNull LocalDateTime take();
}
