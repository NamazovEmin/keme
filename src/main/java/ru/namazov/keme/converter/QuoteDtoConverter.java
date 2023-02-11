package ru.namazov.keme.converter;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.entity.Quote;

@Component
public class QuoteDtoConverter {

    public Quote toEntity(QuoteDto quoteDto) {
        return new Quote(
                quoteDto.getText(),
                quoteDto.getUserId()
        );
    }

    public QuoteDto toDto(Quote quote) {
        return new QuoteDto(
                quote.getId(),
                quote.getText(),
                quote.getUserId()
        );
    }
}
