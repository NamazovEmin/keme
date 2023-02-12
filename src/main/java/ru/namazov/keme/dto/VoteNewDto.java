package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VoteNewDto {

    @JsonProperty(required = true)
    private long userId;

    @JsonProperty(required = true)
    private long quoteId;

    @JsonProperty(required = true)
    private boolean isPositive;
}
