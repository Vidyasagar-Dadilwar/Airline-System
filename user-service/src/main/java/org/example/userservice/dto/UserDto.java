package org.example.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    private String email;

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;


    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "provide valid phone number")
    private String phone;
}
