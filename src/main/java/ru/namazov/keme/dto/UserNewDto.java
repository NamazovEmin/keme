package ru.namazov.keme.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@EqualsAndHashCode
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserNewDto {

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String password;

    @JsonProperty(required = true)
    private String email;
}
