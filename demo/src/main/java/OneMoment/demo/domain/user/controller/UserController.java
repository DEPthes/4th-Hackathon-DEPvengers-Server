package OneMoment.demo.domain.user.controller;

import OneMoment.demo.domain.user.service.UserService;
import OneMoment.demo.global.dto.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "디바이스 정보 저장", description = "주어진 SSAID을 저장합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping("/save")
    public ApiResult<String> saveUserInfo(String ssaid) {
        userService.saveUser(ssaid);

        return ApiResult.ok("성공적으로 저장됨");
    }

    @Operation(summary = "연속 사진 업로드 일수 확인", description = "주어진 SSAID을 바탕으로 연속 사진 업로드 일수 확인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/streak")
    public ApiResult<Integer> getStreak(String ssaid) {
        Integer streak = userService.findStreak(ssaid);

        return ApiResult.ok(streak);
    }
}
