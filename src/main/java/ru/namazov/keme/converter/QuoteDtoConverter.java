package ru.namazov.keme.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;
import ru.namazov.keme.repository.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QuoteDtoConverter {

    private final UserRepository userRepository;

    public Quote toEntity(QuoteNewDto quoteNewDto) {
//        доделать эксепшен если юзер не найден
        User user = userRepository.findById(quoteNewDto.getUserId()).orElseThrow(() -> new RuntimeException("sds"));
        return new Quote(
                quoteNewDto.getText(),
                user
        );
    }

    public QuoteDto toDto(Quote quote) {
        return new QuoteDto(
                quote.getId(),
                quote.getText(),
                quote.getUser().getId(),
                quote.getCountPositiveVote(), quote.getCountNegativeVote()
        );
    }

    public List<QuoteDto> toQuoteDTOList(List<Quote> quotes) {
        return quotes.stream().map(this::toDto).collect(Collectors.toList());
    }

}
