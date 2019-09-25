package com.github.tulliocba.money.api.repository.util;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PageableDelegate <T> {
    public PageableDelegate() {
    }

    public List<T> getResultPageable(Pageable pageable, TypedQuery<T> query) {
        int firstEntry = pageable.getPageNumber() * pageable.getPageSize();

        query.setFirstResult(firstEntry);
        query.setMaxResults(pageable.getPageSize());

        return query.getResultList();
    }
}