package io.tulliocba.springbootcrudjpa.repository;

import io.tulliocba.springbootcrudjpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
