package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.QuoteDtoConverter;
import ru.namazov.keme.dto.QuoteDto;
import ru.namazov.keme.service.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quote")
@CrossOrigin("*")
@AllArgsConstructor
public class QuoteController {

    QuoteDtoConverter quoteDtoConverter;
    QuoteService quoteService;

    @PostMapping
    public QuoteDto create(QuoteDto quoteDto) {
        return quoteDtoConverter.toDto(quoteService.save(quoteDtoConverter.fromDto(quoteDto)));
    }

    @GetMapping
    public QuoteDto get(QuoteDto quoteDto) {
            return quoteDtoConverter.toDto(quoteService.get(quoteDto.getId()));
    }

    @DeleteMapping
    public void delete(QuoteDto quoteDto) {
        quoteService.delete(quoteDtoConverter.fromDto(quoteDto));
    }

    @PutMapping
    public QuoteDto put(QuoteDto quoteDto) {
        return quoteDtoConverter.toDto()
//                как апдейтить??
    }
}
