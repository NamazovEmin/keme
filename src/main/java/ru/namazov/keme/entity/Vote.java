package ru.namazov.keme.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * the vote that a user casts when voting
 */

@Data
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

    /**
     * user who voted
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * quote for which the user votes
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "quote_id", nullable = false)
    private Quote quote;

    /**
     * vote is positive or negative
     */
    @Column(name = "is_positive", nullable = false)
    private boolean isPositive;

    /**
     * vote created time
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Vote(User user, Quote quote, boolean isPositive) {
        this.user = user;
        this.quote = quote;
        this.isPositive = isPositive;
    }
}
