package OneMoment.demo.domain.emoji.repository;

import OneMoment.demo.domain.emoji.entity.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmojiRepository extends JpaRepository<Emoji, Long> {
}
