package ru.namazov.keme.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VotingEventConverter;
import ru.namazov.keme.dto.VotingEventDto;
import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.service.VotingEventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/votingevent")
@AllArgsConstructor
public class VotingEventController {

    private final VotingEventService votingEventService;
    private final VotingEventConverter votingEventConverter;

    @GetMapping("/{id}")
    public ResponseEntity<List<VotingEventDto>> getDiagram(@PathVariable long id) {
        List<VotingEvent> votingEventList = votingEventService.getDiagram(id);
        List<VotingEventDto> votingEventDtoList = votingEventConverter.toVotingEventDtoList(votingEventList);
        return ResponseEntity.ok().body(votingEventDtoList);
    }
}
