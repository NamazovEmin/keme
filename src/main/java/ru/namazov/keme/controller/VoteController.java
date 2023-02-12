package ru.namazov.keme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VoteDtoConverter;
import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.dto.VoteNewDto;
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
    public ResponseEntity<VoteDto> save(@RequestBody VoteNewDto voteNewDto) {
        Vote vote = voteDtoConverter.toEntity(voteNewDto);
        Vote savedVote = voteService.save(vote);
        VoteDto voteDto = voteDtoConverter.toDto(savedVote);
        return ResponseEntity.ok().body(voteDto);
    }
}
