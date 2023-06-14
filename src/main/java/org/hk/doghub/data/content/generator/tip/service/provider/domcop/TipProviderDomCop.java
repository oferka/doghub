package org.hk.doghub.data.content.generator.tip.service.provider.domcop;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hk.doghub.data.content.generator.tip.model.Tip;
import org.hk.doghub.data.content.generator.tip.service.TipProvider;
import org.hk.doghub.data.content.generator.tip.service.provider.domcop.csv.CSVContentProvider;
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
    public List<Tip> get(@Min(MIN_NUMBER_OF_ITEMS) @Max(MAX_NUMBER_OF_ITEMS) int numberOfItems) {
        return csvContentProvider.get(numberOfItems);
    }

    @Override
    public Tip get() {
        return csvContentProvider.get();
    }
}
