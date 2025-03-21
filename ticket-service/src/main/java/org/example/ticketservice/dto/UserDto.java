package org.example.ticketservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String email;

    private String firstName;

    private String lastName;


    private String phone;

}
