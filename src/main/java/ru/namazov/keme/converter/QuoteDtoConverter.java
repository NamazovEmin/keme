package ru.namazov.keme.converter;

import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.entity.Quote;

public class QuoteDtoConverter {

    public Quote fromDto(QuoteDto quoteDto) {
        return new Quote(
                quoteDto.getText(),
                quoteDto.getUser()
        );
    }

    public QuoteDto toDto(Quote quote) {
        return new QuoteDto(
                quote.getId(),
                quote.getText(),
                quote.getUser()
        );
    }
}
