package OneMoment.demo.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String ssaid;

    @Builder
    public UserDto(String ssaid) {
        this.ssaid = ssaid;
    }
}
