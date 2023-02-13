package ru.namazov.keme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VoteDtoConverterImpl;
import ru.namazov.keme.dto.VoteDto;
import ru.namazov.keme.dto.VoteNewDto;
import ru.namazov.keme.entity.Vote;
import ru.namazov.keme.service.VoteServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/votes")
@AllArgsConstructor
public class VoteController {

    private final VoteDtoConverterImpl voteDtoConverterImpl;
    private final VoteServiceImpl voteServiceImpl;

    @PostMapping
    public ResponseEntity<VoteDto> create(@RequestBody VoteNewDto voteNewDto) {
        Vote vote = voteDtoConverterImpl.toEntity(voteNewDto);
        Vote savedVote = voteServiceImpl.create(vote);
        VoteDto voteDto = voteDtoConverterImpl.toDto(savedVote);
        return ResponseEntity.ok().body(voteDto);

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        voteServiceImpl.deleteById(id);
    }
}
