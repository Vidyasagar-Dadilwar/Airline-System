package org.example.userservice.service;

import org.example.userservice.dto.UserDto;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return toDto(user);
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        User user = toUser(userDto);
        return toDto(userRepository.save(user));
    }

    public List<UserDto> getAllUsers() {
        return toDtos(userRepository.findAll());
    }

    private UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone()
        );
    }

    private User toUser(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getEmail(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhone()
        );
    }

    private List<UserDto> toDtos(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }
}