package ru.namazov.keme.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private final long id;
    private final String name;
    private final String password;
    private final String email;

    public UserDto(long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }


    //нужны ли тут тут время создания и обновления

}
