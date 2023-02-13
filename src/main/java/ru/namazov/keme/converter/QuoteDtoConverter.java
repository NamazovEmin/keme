package ru.namazov.keme.converter;

import java.util.List;

import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;

public interface QuoteDtoConverter {

    Quote toEntity(QuoteNewDto quoteNewDto);
    QuoteDto toDto(Quote quote);
    List<QuoteDto> toQuoteDTOList(List<Quote> quotes);
}
