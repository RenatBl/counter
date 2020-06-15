package ru.itis.counter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ru.itis.counter.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String email;

    public static UserDto get(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> get(List<User> users) {
        return users.stream()
                .map(UserDto::get)
                .collect(Collectors.toList());
    }
}
