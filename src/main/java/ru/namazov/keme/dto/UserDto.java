package ru.namazov.keme.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private final long id;
    private final String name;
    private final String surname;
    private final String email;

    public UserDto(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
