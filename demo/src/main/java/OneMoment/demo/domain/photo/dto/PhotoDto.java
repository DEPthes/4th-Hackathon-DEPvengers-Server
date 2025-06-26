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
    private Date uploadDate;
    private String text;
    private String taskID;

    @Builder
    public PhotoDto(Date uploadDate, String text, String taskID) {
        this.uploadDate = uploadDate;
        this.text = text;
        this.taskID = taskID;
    }
}
