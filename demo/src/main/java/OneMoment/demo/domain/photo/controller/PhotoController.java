package OneMoment.demo.domain.photo.controller;

import OneMoment.demo.domain.photo.dto.PhotoDto;
import OneMoment.demo.domain.photo.dto.UrlDto;
import OneMoment.demo.domain.photo.service.PhotoService;
import OneMoment.demo.global.dto.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/photo")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @Operation(summary = "사진 저장", description = "주어진 사진과 정보를 저장하고 음악 URL을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @PostMapping("/save")
    public ApiResult<UrlDto> savePhoto(@RequestParam("file") MultipartFile file, String text, String ssaid) {
        UrlDto url = photoService.savePhoto(ssaid, file, text);

        return ApiResult.ok(url);
    }

    @Operation(summary = "전체 사진 조회", description = "오늘 날짜를 바탕으로 전체 사진 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/today")
    public ApiResult<List<PhotoDto>> getPhotos() {
        return ApiResult.ok(photoService.getPhotos());
    }

    @Operation(summary = "월별 내 사진 조회", description = "월별 내 사진 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 저장됨"),
            @ApiResponse(responseCode = "400", description = "잘못된 입력 값"),
            @ApiResponse(responseCode = "500", description = "서버 오류 발생")
    })
    @GetMapping("/my")
    public ApiResult<List<PhotoDto>> getMyPhotos(String year, String month, String ssaid) {
        return ApiResult.ok(photoService.getPhotosByUser(ssaid, year, month));
    }
}
