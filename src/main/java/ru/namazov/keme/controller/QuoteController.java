package ru.namazov.keme.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.QuoteDtoConverter;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.converter.TopDtoConverter;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.service.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quotes")
@AllArgsConstructor
public class QuoteController {

    private QuoteDtoConverter quoteDtoConverter;
    private QuoteService quoteService;
    private TopDtoConverter topDtoConverter;

    @PostMapping
    public ResponseEntity<QuoteDto> create(@RequestBody QuoteNewDto quoteNewDto) {
        Quote quote = quoteDtoConverter.toEntity(quoteNewDto);
        Quote savedQuote = quoteService.save(quote);
        QuoteDto quoteDto = quoteDtoConverter.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<QuoteDto> get(@PathVariable(required = false) long id) {
        Quote quote = quoteService.get(id);
        QuoteDto quoteDto = quoteDtoConverter.toDto(quote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/top10")
    public List<Long> getTop10() {
        List<Quote> dbList = quoteService.getTop10();
        return topDtoConverter.toDto(dbList);
    }

    @GetMapping("/worst10")
    public List<Long> getWors10() {
        List<Quote> dbList = quoteService.getWorst10();
        return topDtoConverter.toDto(dbList);
    }
}
