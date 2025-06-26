package OneMoment.demo.domain.photo.service;

import OneMoment.demo.domain.emoji.entity.Emoji;
import OneMoment.demo.domain.emoji.repository.EmojiRepository;
import OneMoment.demo.domain.photo.dto.UrlDto;
import OneMoment.demo.domain.photo.entity.Photo;
import OneMoment.demo.domain.photo.repository.PhotoRepository;
import OneMoment.demo.domain.user.entity.User;
import OneMoment.demo.domain.user.repository.UserRepository;
import OneMoment.demo.global.FileStorageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;
    private final EmojiRepository emojiRepository;
    private final FileStorageService fileStorageService;
    private final musicService musicService;

            public UrlDto savePhoto(String ssaid, MultipartFile file, String text) {
                String filename = fileStorageService.store(file);

                Optional<User> existUser = userRepository.findBySsaid(ssaid);

                if(existUser.isPresent()){
                    User user = existUser.get();
                    Date today = new Date();

                    String musicDownURL = musicService.getMusic(text);

                    String musicURl = fileStorageService.uploadFromUrl(musicDownURL);

                    photoRepository.save(Photo.builder()
                            .text(text)
                            .photoURL(filename)
                            .mp3URL(musicURl)
                            .uploadDate(today)
                            .user(user)
                            .build()
                    );

                    Photo photo = photoRepository.findByMp3URL(musicURl);

                    emojiRepository.save(Emoji.builder()
                            .funny(0)
                            .sad(0)
                            .star(0)
                            .angry(0)
                            .love(0)
                            .happy(0)
                            .photo(photo)
                            .build()
                    );

                    return UrlDto.builder()
                            .mp3Url(musicURl)
                            .imageUrl(filename)
                            .build();
                }

                return null;
            }

}
