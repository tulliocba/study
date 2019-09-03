package io.tulliocba.resttemplate.client;

import io.tulliocba.resttemplate.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

public class SpringRestClient {
    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8081/api/v1/employees";
    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees/{id}";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees/{id}";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees/{id}";

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();

        springRestClient.createEmployee();

        springRestClient.getEmployees();

        springRestClient.updateEmployee();

        springRestClient.getEmployeeById();

        springRestClient.deleteEmployee();
    }

    private void deleteEmployee() {
        restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, Collections.singletonMap("id", 2L));
    }

    private void updateEmployee() {
        Employee employee = new Employee("Tulio", "Gabriel da Silva", "tulliocba@gmail.com");

        restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, employee, Collections.singletonMap("id", 1L));
    }

    private void getEmployees() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> exchange = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity, String.class);

        System.out.println(exchange);
    }

    private void getEmployeeById() {
        Employee employee = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, Collections.singletonMap("id", 1L));

        System.out.println(employee);
    }

    private void createEmployee() {
        Employee employee = new Employee("admin", "admin", "teste@hotmail.com");
        Employee employeeCreated = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, employee, Employee.class);
        System.out.println(employeeCreated);
    }
}
