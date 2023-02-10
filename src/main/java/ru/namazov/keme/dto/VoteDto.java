package ru.namazov.keme.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.namazov.keme.entity.Quote;
import ru.namazov.keme.entity.User;

import lombok.Getter;

@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VoteDto {

    private long id;

    @JsonProperty(required = true)
    private User user;

    @JsonProperty(required = true)
    private Quote quote;

    @JsonProperty(required = true)
    private boolean isPositive;

    private Date createDate;

    public VoteDto(long id, User user, Quote quote, boolean isPositive, Date createDate) {
    }
}
