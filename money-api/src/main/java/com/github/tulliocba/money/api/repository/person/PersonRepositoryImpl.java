package com.github.tulliocba.money.api.repository.person;

import com.github.tulliocba.money.api.model.Person;
import com.github.tulliocba.money.api.repository.filter.PersonFilter;
import com.github.tulliocba.money.api.repository.util.PageableDelegate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class PersonRepositoryImpl implements PersonRepositoryQuery {

    @Autowired
    private PageableDelegate<Person> personPageableDelegate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Person> findBy(PersonFilter personFilter, Pageable pageable) {
        StringBuilder sql = new StringBuilder("select person from Person person where 1=1 ");

        if(StringUtils.isNotEmpty(personFilter.getName())){
            sql.append("and lower(person.name) like :name ");
        }

        TypedQuery<Person> query = entityManager.createQuery(sql.toString(), Person.class);

        if(StringUtils.isNotEmpty(personFilter.getName())){
            query.setParameter("name", "%"+personFilter.getName().toLowerCase()+"%");
        }

        int total = query.getResultList().size();

        return new PageImpl<>(personPageableDelegate.getResultPageable(pageable, query), pageable, total);
    }
}
