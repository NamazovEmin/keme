package ru.namazov.keme.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.namazov.keme.entity.User;
import ru.namazov.keme.entity.Vote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QuoteDto {

    @JsonProperty(required = true)
    private long id;

    @JsonProperty(required = true)
    private String text;

    @JsonProperty(required = true)
    private long userId;
}
