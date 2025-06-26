package OneMoment.demo.domain.emoji.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmojiDto {
    private int happy;
    private int funny;
    private int love;
    private int star;
    private int sad;

    @Builder
    public EmojiDto(int happy, int funny, int love, int star, int sad, int angry) {
        this.happy = happy;
        this.funny = funny;
        this.love = love;
        this.star = star;
        this.sad = sad;
    }
}
