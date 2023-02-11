package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class QuoteDto {

    private long id;

    @JsonProperty(required = true)
    private String text;

    @JsonProperty(required = true)
    private long userId;

    public QuoteDto(long id, String text, long userId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
    }
}
