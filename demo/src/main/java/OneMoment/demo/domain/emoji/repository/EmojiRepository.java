package OneMoment.demo.domain.emoji.repository;

import OneMoment.demo.domain.emoji.entity.Emoji;
import OneMoment.demo.domain.photo.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmojiRepository extends JpaRepository<Emoji, Long> {
    Emoji findByPhoto(Photo photo);
}
