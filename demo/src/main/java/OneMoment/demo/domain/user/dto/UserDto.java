package OneMoment.demo.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
