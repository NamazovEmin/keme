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

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
