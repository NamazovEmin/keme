package ru.namazov.keme.dto;

import javax.persistence.Column;

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

    @Column(name = "positive")
    private long countPositiveVote = 0;

    @Column(name = "negative")
    private long countNegativeVote = 0;
}
