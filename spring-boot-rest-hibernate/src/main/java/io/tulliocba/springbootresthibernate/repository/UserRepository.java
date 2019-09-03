package io.tulliocba.springbootresthibernate.repository;

import io.tulliocba.springbootresthibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
