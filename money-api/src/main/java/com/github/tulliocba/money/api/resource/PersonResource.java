package com.github.tulliocba.money.api.resource;

import com.github.tulliocba.money.api.event.CreatedResourceEvent;
import com.github.tulliocba.money.api.model.Person;
import com.github.tulliocba.money.api.repository.person.PersonRepository;
import com.github.tulliocba.money.api.repository.filter.PersonFilter;
import com.github.tulliocba.money.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private PersonService personService;


    @GetMapping
    public List<Person> list(){
        return personRepository.findAll();
    }

    @GetMapping("/{personId}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') && #oauth2.hasScope('read')")
    public ResponseEntity<?> findById(@PathVariable Integer personId){
        Optional<Person> person = Optional.ofNullable(personRepository.findOne(personId));
        return person.isPresent() ? ResponseEntity.ok(person.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') && #oauth2.hasScope('read')")
    public Page<Person> findBy(PersonFilter personFilter, Pageable pageable){
        return personRepository.findBy(personFilter, pageable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') && #oauth2.hasScope('write')")
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response){
        Person savedPerson = personRepository.save(person);
        publisher.publishEvent(new CreatedResourceEvent(this, response, savedPerson.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA') and #oauth2.hasScope('write')")
    public void delete(@PathVariable Integer personId){
        personRepository.delete(personId);
    }

    @PutMapping("/{personId}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') && #oauth2.hasScope('write')")
    public ResponseEntity<Person> update(@PathVariable Integer personId, @Valid @RequestBody Person person){
        Person updatedPerson = personService.updatePerson(personId, person);
        return ResponseEntity.ok(updatedPerson);
    }

    @PutMapping("/{personId}/enabled")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') && oauth2.hasScope('write')")
    public void changePersonEnabledState(@PathVariable Integer personId, @RequestBody Boolean isEnabled){
        personService.changePersonEnabledState(personId, isEnabled);
    }
}
