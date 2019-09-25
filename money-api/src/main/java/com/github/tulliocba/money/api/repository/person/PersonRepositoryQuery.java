package com.github.tulliocba.money.api.repository.person;

import com.github.tulliocba.money.api.model.Person;
import com.github.tulliocba.money.api.repository.filter.PersonFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonRepositoryQuery {

    Page<Person> findBy(PersonFilter personFilter, Pageable pageable);
}
