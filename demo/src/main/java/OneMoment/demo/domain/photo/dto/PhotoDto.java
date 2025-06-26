package OneMoment.demo.domain.photo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PhotoDto {
    private String date;
    private String text;
    private String imageUrl;
    private String mp3Url;
    private int happy;
    private int funny;
    private int love;
    private int star;
    private int sad;


    @Builder
    public PhotoDto(String date, String text, String imageUrl, String mp3Url, int happy, int funny, int love, int star, int sad) {
        this.date = date;
        this.text = text;
        this.imageUrl = imageUrl;
        this.mp3Url = mp3Url;
        this.happy = happy;
        this.funny = funny;
        this.love = love;
        this.star = star;
        this.sad = sad;
    }
}
