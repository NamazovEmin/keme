package ru.namazov.keme.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.QuoteDtoConverter;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.service.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quotes")
@AllArgsConstructor
public class QuoteController {

    private QuoteDtoConverter quoteDtoConverter;
    private QuoteService quoteService;


    @PostMapping
    public QuoteDto create(@RequestBody QuoteDto quoteDto) {
        Quote quote = quoteDtoConverter.toEntity(quoteDto);
        Quote savedQuote = quoteService.save(quote);
        return quoteDtoConverter.toDto(savedQuote);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public QuoteDto get(@PathVariable(required = false) long id) {
                return quoteDtoConverter.toDto(quoteService.get(id));
    }

    @GetMapping("/top10")
    @ResponseBody
    public List<Quote> get() {
        return quoteService.getTop10();
    }

    @DeleteMapping
    public void delete(@RequestBody QuoteDto quoteDto) {
        quoteService.delete(quoteDtoConverter.toEntity(quoteDto));
    }

    @PutMapping
    public QuoteDto put(@RequestBody QuoteDto quoteDto) {
        return quoteDtoConverter.toDto(quoteService.save(quoteDtoConverter.toEntity(quoteDto)));
    }
}
