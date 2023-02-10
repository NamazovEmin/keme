package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VoteDtoConverter;
import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.service.VoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/vote")
@AllArgsConstructor
public class VotingController {

    private final VoteDtoConverter voteDtoConverter;
    private final VoteService voteService;

    @PostMapping
    public VoteDto save(VoteDto voteDto) {
        return voteDtoConverter.toDto(voteService.save(voteDtoConverter.fromDto(voteDto)));
    }
}
