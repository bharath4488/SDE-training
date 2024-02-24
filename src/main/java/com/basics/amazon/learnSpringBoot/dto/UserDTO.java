package com.basics.amazon.learnSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

    public UserDTO() {
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
