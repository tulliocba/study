package com.github.tulliocba.money.api.repository.person;

import com.github.tulliocba.money.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryQuery {
}
