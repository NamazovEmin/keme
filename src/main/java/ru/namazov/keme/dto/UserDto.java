package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto {

    private final long id;

    @JsonProperty(required = true)
    private final String name;

    @JsonProperty(required = true)
    private final String password;

    @JsonProperty(required = true)
    private final String email;

    public UserDto(long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
