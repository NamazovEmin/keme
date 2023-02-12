/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.namazov.keme.entity.Quote;

@Component
public class TopDtoConverter {

    public List<Long> toDto(List<Quote> list) {
        List<Long> topList = new ArrayList<>();
        for(Quote top: list) {
            topList.add(top.getId());
        }
        return topList;
    }
}
