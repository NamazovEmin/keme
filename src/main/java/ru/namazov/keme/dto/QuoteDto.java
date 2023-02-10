package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.namazov.keme.entity.User;

import lombok.Getter;

@Getter
public class QuoteDto {

    private long id;

    @JsonProperty(required = true)
    private String text;

    @JsonProperty(required = true)
    private User user;

    public QuoteDto(long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }
}
