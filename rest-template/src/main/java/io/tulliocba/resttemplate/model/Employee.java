package io.tulliocba.resttemplate.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@NoArgsConstructor
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailId;

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}
