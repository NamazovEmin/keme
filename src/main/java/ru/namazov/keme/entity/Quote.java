package ru.namazov.keme.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "quotes")
@NoArgsConstructor
@Getter
@Setter
//@ToString(exclude = "votes")
public class Quote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @OneToMany(mappedBy = "quote")
    private List<Vote> voteList;

    @Column(name = "positive")
    private long countPositiveVote = 0;

    @Column(name = "negative")
    private long countNegativeVote = 0;

    public Quote(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
