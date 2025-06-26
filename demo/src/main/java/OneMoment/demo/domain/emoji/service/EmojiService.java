package OneMoment.demo.domain.emoji.service;

import OneMoment.demo.domain.emoji.dto.EmojiDto;
import OneMoment.demo.domain.emoji.entity.Emoji;
import OneMoment.demo.domain.emoji.repository.EmojiRepository;
import OneMoment.demo.domain.photo.entity.Photo;
import OneMoment.demo.domain.photo.repository.PhotoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EmojiService {

    private final EmojiRepository emojiRepository;
    private final PhotoRepository photoRepository;

    public EmojiDto upEmoji(int number, String photoUrl){
        Photo photo = photoRepository.findByPhotoURL(photoUrl);

        Emoji emoji = emojiRepository.findByPhoto(photo);

        if (number == 1){
            int happyNum = emoji.getHappy();
            emoji.setHappy(happyNum + 1);
            emojiRepository.save(emoji);
        } else if (number == 2) {
            int funnyNum = emoji.getFunny();
            emoji.setFunny(funnyNum + 1);
            emojiRepository.save(emoji);
        } else if (number == 3) {
            int loveNum = emoji.getLove();
            emoji.setLove(loveNum + 1);
            emojiRepository.save(emoji);
        } else if (number == 4) {
            int starNum = emoji.getStar();
            emoji.setStar(starNum + 1);
            emojiRepository.save(emoji);
        } else if (number == 5) {
            int sadNum = emoji.getSad();
            emoji.setSad(sadNum + 1);
            emojiRepository.save(emoji);
        }

        return EmojiDto.builder()
                .happy(emoji.getHappy())
                .funny(emoji.getFunny())
                .love(emoji.getLove())
                .star(emoji.getStar())
                .sad(emoji.getSad())
                .build();
    }

    public EmojiDto downEmoji(int number, String photoUrl){
        Photo photo = photoRepository.findByPhotoURL(photoUrl);

        Emoji emoji = emojiRepository.findByPhoto(photo);

        if (number == 1){
            int happyNum = emoji.getHappy();
            emoji.setHappy(happyNum - 1);
            emojiRepository.save(emoji);
        } else if (number == 2) {
            int funnyNum = emoji.getFunny();
            emoji.setFunny(funnyNum - 1);
            emojiRepository.save(emoji);
        } else if (number == 3) {
            int loveNum = emoji.getLove();
            emoji.setLove(loveNum - 1);
            emojiRepository.save(emoji);
        } else if (number == 4) {
            int starNum = emoji.getStar();
            emoji.setStar(starNum - 1);
            emojiRepository.save(emoji);
        } else if (number == 5) {
            int sadNum = emoji.getSad();
            emoji.setSad(sadNum - 1);
            emojiRepository.save(emoji);
        }


        return EmojiDto.builder()
                .happy(emoji.getHappy())
                .funny(emoji.getFunny())
                .love(emoji.getLove())
                .star(emoji.getStar())
                .sad(emoji.getSad())
                .build();
    }
}
