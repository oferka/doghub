package org.hk.doghub.data.content.generator.tip.domcop;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.Tip;
import org.hk.doghub.data.content.generator.tip.TipProvider;
import org.hk.doghub.data.content.generator.tip.domcop.csv.CSVContentProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
@Primary
public class TipProviderDomCop implements TipProvider {

    private final CSVContentProvider csvContentProvider;

    @Override
    public @NotNull List<Tip> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        return csvContentProvider.get(numberOfItems);
    }

    @Override
    public @NotNull Tip get() {
        return csvContentProvider.get();
    }
}
