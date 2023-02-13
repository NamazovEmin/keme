package ru.namazov.keme.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import ru.namazov.keme.enums.VoteEventType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The history of users voting for a quote, as well as the cancellation of their votes.
 * History allows you to find out what was the rating of the quote, at any time
 */

@Data
@Entity
@Table(name = "voting_events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VotingEvent {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * id of the quote voted for
     */
    @Column(name = "quote_id")
    private long quoteId;

    /**
     * voting id
     */
    @Column(name = "vote_id")
    private long voteId;

    /**
     * voting type
     */
    @Enumerated
    @Column(name = "event_type")
    private VoteEventType eventType;

    /**
     * total number of likes at the moment of voting
     */
    @Column(name = "countLike")
    private long countLikeAtThisTime;

    /**
     * total number of dislikes at the moment of voting
     */
    @Column(name = "countDisLike")
    private long countDisLikeAtThisTime;

    /**
     * time of the operation
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public VotingEvent(long quoteId, VoteEventType eventType, long countLikeAtThisTime, long countDisLikeAtThisTime) {
        this.quoteId = quoteId;
        this.eventType = eventType;
        this.countLikeAtThisTime = countLikeAtThisTime;
        this.countDisLikeAtThisTime = countDisLikeAtThisTime;
    }
}
