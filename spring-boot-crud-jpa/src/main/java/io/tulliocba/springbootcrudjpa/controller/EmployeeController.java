package io.tulliocba.springbootcrudjpa.controller;


import io.tulliocba.springbootcrudjpa.model.Employee;
import io.tulliocba.springbootcrudjpa.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.isPresent() ? ResponseEntity.of(employee) : ResponseEntity.noContent().build();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if(!optionalEmployee.isPresent()) return ResponseEntity.noContent().build();

        Employee employee = optionalEmployee.get();
        BeanUtils.copyProperties(employee, employeeDetails, "id");

        return ResponseEntity.of(Optional.of(employeeRepository.save(employee)));
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if(!optionalEmployee.isPresent()) return ResponseEntity.noContent().build();

        employeeRepository.delete(optionalEmployee.get());

        return ResponseEntity.of(Optional.of(Collections.singletonMap("deleted", true)));
    }
}
