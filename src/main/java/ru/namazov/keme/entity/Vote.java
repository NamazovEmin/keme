package ru.namazov.keme.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vote")
@NoArgsConstructor
@Getter
public class Vote {

    @Id
    @Column(name = "vote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    private Quote quote;

    @Column(name = "is_positive")
    private boolean isPositive;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Vote(User user, Quote quote, boolean isPositive) {
    }
}
