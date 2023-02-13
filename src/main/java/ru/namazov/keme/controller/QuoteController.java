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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.QuoteDtoConverterImpl;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.exceptions.ResourceNotFoundResponseException;
import ru.namazov.keme.service.QuoteServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quotes")
@AllArgsConstructor
public class QuoteController {

    private final QuoteDtoConverterImpl quoteDtoConverterImpl;
    private final QuoteServiceImpl quoteServiceImpl;

    @PostMapping
    public ResponseEntity<QuoteDto> create(@RequestBody QuoteNewDto quoteNewDto) {
        Quote quote = quoteDtoConverterImpl.toEntity(quoteNewDto);
        Quote savedQuote = quoteServiceImpl.save(quote);
        QuoteDto quoteDto = quoteDtoConverterImpl.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<QuoteDto> get(@PathVariable(required = false) long id) {
        Quote quote = quoteServiceImpl.findById(id).orElseThrow(() ->
                new ResourceNotFoundResponseException(String.format("User with id: %d not found", id)));
        QuoteDto quoteDto = quoteDtoConverterImpl.toDto(quote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @GetMapping("/chart/{topCount}/{whichTop}")
    public ResponseEntity<List<QuoteDto>> getTop(@PathVariable(name ="topCount") Long topCount, @PathVariable(name = "whichTop") Boolean whichTop) {
        List<Quote> dbList = quoteServiceImpl.getTop(topCount, whichTop);
        List<QuoteDto> top10List = quoteDtoConverterImpl.toQuoteDTOList(dbList);
        return ResponseEntity.ok().body(top10List);
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDto> getRandom() {
        Quote quote = quoteServiceImpl.getRandom();
        QuoteDto quoteDto = quoteDtoConverterImpl.toDto(quote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<QuoteDto> put(@RequestBody QuoteNewDto quoteNewDto,
                                        @PathVariable Long id) {
        Quote quote = quoteDtoConverterImpl.toEntity(quoteNewDto);
        Quote savedQuote = quoteServiceImpl.put(quote, id);
        QuoteDto quoteDto = quoteDtoConverterImpl.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        quoteServiceImpl.delete(id);
    }
}
