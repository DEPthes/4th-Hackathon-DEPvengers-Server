package OneMoment.demo.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ssaid;
    private Integer streak;

    @Column(name = "last_upload", nullable = true)
    private Date lastUpload;

    @Builder
    public User(String ssaid, Integer streak, Date lastUpload) {
        this.ssaid = ssaid;
        this.streak = streak;
        this.lastUpload = lastUpload;
    }
}
