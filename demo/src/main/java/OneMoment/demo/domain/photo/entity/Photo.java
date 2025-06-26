package OneMoment.demo.domain.photo.entity;

import OneMoment.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_URL", nullable = true, length = 2048)
    private String photoURL;

    @Column(name = "mp3_URL", nullable = true, length = 2048)
    private String mp3URL;

    private Date uploadDate;

    @Column(name = "text", nullable = true)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Photo(String photoURL, String mp3URL, Date uploadDate, String text, User user) {
        this.photoURL = photoURL;
        this.mp3URL = mp3URL;
        this.uploadDate = uploadDate;
        this.text = text;
        this.user = user;
    }
}
