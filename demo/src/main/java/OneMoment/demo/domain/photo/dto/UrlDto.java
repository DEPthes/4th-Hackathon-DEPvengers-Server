package OneMoment.demo.domain.photo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UrlDto {
    private String imageUrl;
    private String mp3Url;

    @Builder
    public UrlDto(String imageUrl, String mp3Url) {
        this.imageUrl = imageUrl;
        this.mp3Url = mp3Url;
    }
}
