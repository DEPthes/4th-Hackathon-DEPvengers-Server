package OneMoment.demo.domain.photo.repository;

import OneMoment.demo.domain.photo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
