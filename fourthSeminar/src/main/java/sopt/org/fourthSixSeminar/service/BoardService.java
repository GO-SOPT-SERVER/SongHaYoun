package sopt.org.fourthSixSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSixSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.fourthSixSeminar.domain.Board;
import sopt.org.fourthSixSeminar.domain.User;
import sopt.org.fourthSixSeminar.exception.Error;
import sopt.org.fourthSixSeminar.exception.model.NotFoundException;
import sopt.org.fourthSixSeminar.infrastructure.BoardRepository;
import sopt.org.fourthSixSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(BoardRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}