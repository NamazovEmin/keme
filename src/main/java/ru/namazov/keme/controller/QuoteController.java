package ru.namazov.keme.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.QuoteDtoConverter;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.service.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quotes")
@AllArgsConstructor
public class QuoteController {

    private final QuoteDtoConverter quoteDtoConverter;
    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteDto> create(@RequestBody QuoteNewDto quoteNewDto) {
        Quote quote = quoteDtoConverter.toEntity(quoteNewDto);
        Quote savedQuote = quoteService.create(quote);
        QuoteDto quoteDto = quoteDtoConverter.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteDto> get(@PathVariable long id) {
        Quote quote = quoteService.findById(id).orElseThrow(() ->
                new ResourceNotFoundResponseException(String.format("User with id: %d not found", id)));
        QuoteDto quoteDto = quoteDtoConverter.toDto(quote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/chart/{topCount}/{whichTop}")
    public ResponseEntity<List<QuoteDto>> chartList(@PathVariable(name ="topCount") Long topCount, @PathVariable(name = "whichTop") Boolean whichTop) {
        List<Quote> dbList = quoteService.getTop(topCount, whichTop);
        List<QuoteDto> top10List = quoteDtoConverter.toQuoteDTOList(dbList);
        return ResponseEntity.ok().body(top10List);
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDto> getRandom() {
        Quote quote = quoteService.getRandom();
        QuoteDto quoteDto = quoteDtoConverter.toDto(quote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuoteDto> update(@RequestBody QuoteNewDto quoteNewDto,
                                        @PathVariable Long id) {
        Quote quote = quoteDtoConverter.toEntity(quoteNewDto);
        Quote savedQuote = quoteService.update(quote, id);
        QuoteDto quoteDto = quoteDtoConverter.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quoteService.delete(id);
    }
}
