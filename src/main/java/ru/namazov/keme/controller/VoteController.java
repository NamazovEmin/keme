package ru.namazov.keme.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VoteDtoConverter;
import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.service.VoteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/votes")
@AllArgsConstructor
public class VoteController {

    private final VoteDtoConverter voteDtoConverter;
    private final VoteService voteService;

    @PostMapping
    public VoteDto save(@RequestBody VoteDto voteDto) {
        Vote vote = voteDtoConverter.toEntity(voteDto);
        Vote savedVote = voteService.save(vote);
        return voteDtoConverter.toDto(savedVote);
    }
}
