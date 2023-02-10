package ru.namazov.keme.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quote")
@NoArgsConstructor
@Getter
public class Quote {

    @Id
    @Column(name = "quote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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



    public Quote(String text, User user) {
    }
}
