package sopt.org.fourthSixSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSixSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSixSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSixSeminar.domain.User;
import sopt.org.fourthSixSeminar.exception.Error;
import sopt.org.fourthSixSeminar.exception.model.ConflictException;
import sopt.org.fourthSixSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto create(UserRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException(Error.ALREADY_EXIST_USER_EXCEPTION, Error.ALREADY_EXIST_USER_EXCEPTION.getMessage());
        }

        User newUser = User.newInstance(
                request.getNickname(),
                request.getEmail(),
                request.getPassword()
        );

        userRepository.save(newUser);

        return UserResponseDto.of(newUser.getId(), newUser.getNickname());
    }
}