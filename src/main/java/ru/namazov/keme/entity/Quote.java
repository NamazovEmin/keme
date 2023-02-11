package ru.namazov.keme.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quotes")
@NoArgsConstructor
@Getter
public class Quote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "text", nullable = false)
    private String text;

//    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private long userId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    @OneToMany
    @JoinColumn(name = "vote_id")
    private final List<Vote> voteList = new ArrayList<>();

    public Quote(String text, long userId) {
        this.text = text;
        this.userId = userId;
    }
}
