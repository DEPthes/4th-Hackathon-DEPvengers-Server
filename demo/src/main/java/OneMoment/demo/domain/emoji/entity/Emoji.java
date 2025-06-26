package OneMoment.demo.domain.emoji.entity;

import OneMoment.demo.domain.photo.entity.Photo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Emoji")
public class Emoji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int happy;
    private int funny;
    private int love;
    private int star;
    private int sad;
    private int angry;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Builder
    public Emoji(Integer happy, Integer funny, Integer love, Integer star, Integer sad, Integer angry, Photo photo) {
        this.happy = happy;
        this.funny = funny;
        this.love = love;
        this.star = star;
        this.sad = sad;
        this.angry = angry;
        this.photo = photo;
    }
}
