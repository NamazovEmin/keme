package ru.namazov.keme.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import ru.namazov.keme.entity.User;

import lombok.Getter;

@Getter
public class QuoteDto {

    private long id;

    private String text;

    private User user;

    public QuoteDto(long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }

    //нужны ли тут тут время создания и обновления

}
