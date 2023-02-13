package ru.namazov.keme.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.namazov.keme.converter.VotingEventConverterImpl;
import ru.namazov.keme.dto.VotingEventDto;
import ru.namazov.keme.entity.VotingEvent;
import ru.namazov.keme.service.VotingEventServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/votingevent")
@AllArgsConstructor
public class VotingEventController {

    private final VotingEventServiceImpl votingEventServiceImpl;
    private final VotingEventConverterImpl votingEventConverterImpl;


    @GetMapping("/{id}")
    public ResponseEntity<List<VotingEventDto>> getDiagram(@PathVariable long id) {
        List<VotingEvent> votingEventList = votingEventServiceImpl.getDiagram(id);
        List<VotingEventDto> votingEventDtoList = votingEventConverterImpl.toVotingEventDtoList(votingEventList);
        return ResponseEntity.ok().body(votingEventDtoList);
    }
}
