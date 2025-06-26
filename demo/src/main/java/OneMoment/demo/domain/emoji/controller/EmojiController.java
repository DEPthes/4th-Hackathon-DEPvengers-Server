package OneMoment.demo.domain.emoji.controller;

import OneMoment.demo.domain.emoji.dto.EmojiDto;
import OneMoment.demo.domain.emoji.service.EmojiService;
import OneMoment.demo.global.dto.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/emoji")
@RequiredArgsConstructor
public class EmojiController {

    private final EmojiService emojiService;

    @Operation(summary = "이모지 up", description = "이모지 up.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping("/up")
    public ApiResult<EmojiDto> upEmoji(String imageUrl, int number) {
       EmojiDto emojiDto = emojiService.upEmoji(number, imageUrl);

       return ApiResult.ok(emojiDto);
    }

    @Operation(summary = "이모지 down", description = "이모지 down.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping("/down")
    public ApiResult<EmojiDto> downEmoji(String imageUrl, int number) {
        EmojiDto emojiDto = emojiService.downEmoji(number, imageUrl);

        return ApiResult.ok(emojiDto);
    }
}
