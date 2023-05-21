package org.hk.doghub.automation.e2e.selenium.element.state.retrieve;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.openqa.selenium.By;

public record ElementState(@Getter @NotNull @Size(min = 2, max = 256) @NotBlank String name, @Getter @NotNull By indicatorLocator) {
}
