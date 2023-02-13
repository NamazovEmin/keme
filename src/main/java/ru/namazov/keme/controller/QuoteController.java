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

import ru.namazov.keme.converter.QuoteDtoConverter;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.dto.QuoteNewDto;
import ru.namazov.keme.entity.Quote;
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

    @GetMapping("/chart/{topCount}/{whichTop}")
    public ResponseEntity<List<QuoteDto>> getTop(@PathVariable(name ="topCount") Long topCount, @PathVariable(name = "whichTop") Boolean whichTop) {
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
    @ResponseBody
    public ResponseEntity<QuoteDto> put(@RequestBody QuoteNewDto quoteNewDto,
                                        @PathVariable Long id) {
        Quote quote = quoteDtoConverter.toEntity(quoteNewDto);
        Quote savedQuote = quoteService.put(quote, id);
        QuoteDto quoteDto = quoteDtoConverter.toDto(savedQuote);
        return ResponseEntity.ok().body(quoteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        quoteService.delete(id);
    }
}
