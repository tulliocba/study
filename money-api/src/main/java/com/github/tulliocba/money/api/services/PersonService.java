package com.github.tulliocba.money.api.services;

import com.github.tulliocba.money.api.model.Person;
import com.github.tulliocba.money.api.repository.person.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person updatePerson(Integer personId, Person person) {
        Person savedPerson = findPersonBy(personId);
        BeanUtils.copyProperties(person, savedPerson, "id");
        return personRepository.save(savedPerson);
    }

    public Person findPersonBy(Integer personId) {
        return Optional.ofNullable(personRepository.findOne(personId))
                    .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void changePersonEnabledState(Integer personId, Boolean isEnabled) {
        Person savedPerson = findPersonBy(personId);
        savedPerson.setEnabled(isEnabled);
        personRepository.save(savedPerson);
    }
}
