package OneMoment.demo.domain.photo.repository;

import OneMoment.demo.domain.photo.entity.Photo;
import OneMoment.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo findByMp3URL(String mp3URL);
    Photo findByPhotoURL(String photoURL);

    @Query("SELECT p FROM Photo p WHERE FUNCTION('DATE', p.uploadDate) = CURRENT_DATE")
    List<Photo> findAllUploadedToday();

    List<Photo> findAllByUserOrderByUploadDate(User user);
}
