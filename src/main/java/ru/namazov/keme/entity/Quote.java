package ru.namazov.keme.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a quote that the user creates
 */

@Entity
@Table(name = "quotes")
@NoArgsConstructor
@Getter
@Setter
public class Quote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Content
     */
    @Column(name = "text", nullable = false)
    private String text;

    /**
     * the user who created the quote
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    /**
     * quote created time
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    /**
     * quote updatet time
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * list of votes for this quote
     */
    @OneToMany(mappedBy = "quote", orphanRemoval = true)
    private List<Vote> voteList;

    /**
     * total number of positive votes at the moment
     */
    @Column(name = "count_positives")
    private long countPositiveVotes;

    /**
     * total number of negative votes at the moment
     */
    @Column(name = "count_negatives")
    private long countNegativeVotes;

    public Quote(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
