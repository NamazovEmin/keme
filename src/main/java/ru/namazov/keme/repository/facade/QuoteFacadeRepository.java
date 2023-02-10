/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.keme.repository.facade;

import ru.namazov.keme.entity.Quote;

public interface QuoteFacadeRepository {

    Quote save(Quote quote);
    Quote get(long id);
    void delete(Quote quote);
}
