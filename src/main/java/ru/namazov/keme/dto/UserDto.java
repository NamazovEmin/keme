package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto {

    private long id;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String password;

    @JsonProperty(required = true)
    private String email;

    public UserDto(long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
