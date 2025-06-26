package OneMoment.demo.domain.photo.entity;

import OneMoment.demo.domain.user.entity.User;
import OneMoment.demo.global.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

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
    private String photoURL;
    private String mp3URL;

    @Column(columnDefinition = "JSON")
    @Convert(converter = StringListConverter.class)
    private List<String> tags;

    private Date uploadDate;
    private String text;
    private String taskID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Photo(String photoURL, String mp3URL, List<String> tags, Date uploadDate, String text, String taskID, User user) {
        this.photoURL = photoURL;
        this.mp3URL = mp3URL;
        this.tags = tags;
        this.uploadDate = uploadDate;
        this.text = text;
        this.taskID = taskID;
        this.user = user;
    }
}
