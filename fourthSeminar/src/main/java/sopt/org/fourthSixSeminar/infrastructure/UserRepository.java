package sopt.org.fourthSixSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSixSeminar.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    // CREATE
    void save(User user);

    // READ
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    // UPDATE

    // DELETE
}