package org.hk.doghub.data.content.generator.tip.service.provider.domcop.csv;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CsvLineReader {

    public @NotNull TipLine read(@NotNull String[] line) {
        String id = line[0];
        String address = line[1];
        String popularity = line[2];
        return new TipLine(id, address, popularity);
    }
}
