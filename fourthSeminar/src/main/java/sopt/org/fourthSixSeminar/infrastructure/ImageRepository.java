package sopt.org.fourthSixSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSixSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}