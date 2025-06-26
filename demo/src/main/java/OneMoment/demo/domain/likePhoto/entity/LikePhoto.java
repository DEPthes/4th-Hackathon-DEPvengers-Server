package OneMoment.demo.domain.likePhoto.entity;

import OneMoment.demo.domain.photo.entity.Photo;
import OneMoment.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "LikePhoto")
public class LikePhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer happy;
    private Integer funny;
    private Integer love;
    private Integer star;
    private Integer sad;
    private Integer angry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Builder
    public LikePhoto(Integer happy, Integer funny, Integer love, Integer star, Integer sad, Integer angry, User user, Photo photo) {
        this.happy = happy;
        this.funny = funny;
        this.love = love;
        this.star = star;
        this.sad = sad;
        this.angry = angry;
        this.user = user;
        this.photo = photo;
    }
}
