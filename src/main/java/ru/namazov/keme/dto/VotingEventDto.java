/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;

import ru.namazov.keme.enums.VoteEventType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VotingEventDto {

    private long id;

    @JsonProperty(required = true)
    private long quoteId;

    @JsonProperty(required = true)
    private long voteId;

    @JsonProperty(required = true)
    private VoteEventType eventType;

    @JsonProperty(required = true)
    private long countLikeAtThisTime;

    @JsonProperty(required = true)
    private long countDisLikeAtThisTime;

    @JsonProperty(required = true)
    private Date createDate;
}
