package OneMoment.demo.domain.photo.service;

import OneMoment.demo.domain.emoji.entity.Emoji;
import OneMoment.demo.domain.emoji.repository.EmojiRepository;
import OneMoment.demo.domain.photo.dto.PhotoDto;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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


            public List<PhotoDto> getPhotos() {
                List<Photo> photos = photoRepository.findAllUploadedToday();

                List<PhotoDto> photoDtos = new ArrayList<>();

                for (Photo photo : photos) {
                    Emoji emoji = emojiRepository.findByPhoto(photo);
                    Date uploadDate = photo.getUploadDate(); // 엔티티에서 getter로 받은 Date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateOnly = sdf.format(uploadDate);

                    PhotoDto photoDto = PhotoDto.builder()
                            .date(dateOnly)
                            .text(photo.getText())
                            .imageUrl(photo.getPhotoURL())
                            .mp3Url(photo.getMp3URL())
                            .happy(emoji.getHappy())
                            .funny(emoji.getFunny())
                            .love(emoji.getLove())
                            .happy(emoji.getHappy())
                            .sad(emoji.getSad())
                            .build();

                    photoDtos.add(photoDto);
                }

                return photoDtos;
            }

            public List<PhotoDto> getPhotosByUser(String ssaid, String year, String month) {
                Optional<User> existUser = userRepository.findBySsaid(ssaid);

                if(!existUser.isPresent()){
                    return null;
                }

                User user = existUser.get();

                List<Photo> photos = photoRepository.findAllByUserOrderByUploadDate(user);
                List<PhotoDto> photoDtos = new ArrayList<>();

                for (Photo photo : photos) {
                    Emoji emoji = emojiRepository.findByPhoto(photo);
                    Date uploadDate = photo.getUploadDate(); // 엔티티에서 getter로 받은 Date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateOnly = sdf.format(uploadDate);

                    String[] parts = dateOnly.split("-");
                    String imageYear = parts[0];
                    String imageMonth = parts[1];

                    if (year.equals(year) && imageMonth.equals(month)){
                        PhotoDto photoDto = PhotoDto.builder()
                                .date(dateOnly)
                                .text(photo.getText())
                                .imageUrl(photo.getPhotoURL())
                                .mp3Url(photo.getMp3URL())
                                .happy(emoji.getHappy())
                                .funny(emoji.getFunny())
                                .love(emoji.getLove())
                                .happy(emoji.getHappy())
                                .sad(emoji.getSad())
                                .build();

                        photoDtos.add(photoDto);
                    }
                }

                return photoDtos;
            }
}
