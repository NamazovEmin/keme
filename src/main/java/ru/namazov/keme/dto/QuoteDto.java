package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    private long countPositiveVote;

    private long countNegativeVote;
}
