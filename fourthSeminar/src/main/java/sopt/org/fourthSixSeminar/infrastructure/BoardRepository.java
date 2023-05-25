package sopt.org.fourthSixSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSixSeminar.domain.Board;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ


    // UPDATE

    // DELETE
}