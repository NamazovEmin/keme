package ru.namazov.keme.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VoteDto {

    private long id;

    @JsonProperty(required = true)
    private long userId;

    @JsonProperty(required = true)
    private long quoteId;

    @JsonProperty(value = "isPositive", required = true)
    private boolean isPositive;

    private Date createDate;
}
