package sopt.org.fourthSixSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSixSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.fourthSixSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.fourthSixSeminar.domain.Board;
import sopt.org.fourthSixSeminar.domain.Image;
import sopt.org.fourthSixSeminar.domain.User;
import sopt.org.fourthSixSeminar.exception.Error;
import sopt.org.fourthSixSeminar.exception.model.NotFoundException;
import sopt.org.fourthSixSeminar.infrastructure.BoardRepository;
import sopt.org.fourthSixSeminar.infrastructure.ImageRepository;
import sopt.org.fourthSixSeminar.infrastructure.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, List<String> boardImageUrlList, BoardImageListRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        // 게시글 생성
        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        // 이미지 생성
        for (String boardImageUrl: boardImageUrlList) {
            imageRepository.save(Image.newInstance(newBoard, boardImageUrl));
        }
    }
}