package ru.namazov.keme.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "votes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Vote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
    @JoinColumn(name = "user_id")
    private long userId;

//    @ManyToOne
    @JoinColumn(name = "quote_id")
    private long quoteId;

    @Column(name = "is_positive")
    private boolean isPositive;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Vote(long userId, long quoteId, boolean isPositive) {
        this.userId = userId;
        this.quoteId = quoteId;
        this.isPositive = isPositive;
    }
}
