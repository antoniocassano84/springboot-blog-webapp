package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
