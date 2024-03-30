package com.bmu.university.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "User 'firstName' shouldn't be empty !!")
    private String firstName;
    @NotEmpty(message = "User 'lastName' shouldn't be empty !!")
    private String lastName;
    @NotEmpty(message = "User 'email' shouldn't be empty !!")
    @Email
    private String email;
}
