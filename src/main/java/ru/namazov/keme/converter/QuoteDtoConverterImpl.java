package ru.namazov.keme.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QuoteDtoConverterImpl implements QuoteDtoConverter {

    private final UserService userService;

    @Override
    public Quote toEntity(QuoteNewDto quoteNewDto) {
        User user = userService.findById(quoteNewDto.getUserId()).orElseThrow(() -> new ResourceNotFoundResponseException(String.format("User with id: %d not found", quoteNewDto.getUserId())));
        return new Quote(
                quoteNewDto.getText(),
                user
        );
    }
    @Override
    public QuoteDto toDto(Quote quote) {
        return new QuoteDto(
                quote.getId(),
                quote.getText(),
                quote.getUser().getId(),
                quote.getCountPositiveVotes(), quote.getCountNegativeVotes()
        );
    }

    @Override
    public List<QuoteDto> toQuoteDTOList(List<Quote> quotes) {
        return quotes.stream().map(this::toDto).collect(Collectors.toList());
    }
}
