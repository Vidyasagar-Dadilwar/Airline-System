package org.example.ticketservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String phone;
    private String firstName;
    private String lastName;
    private Long id;
    private String email;
}