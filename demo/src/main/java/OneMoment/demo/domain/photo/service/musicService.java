package OneMoment.demo.domain.photo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Transactional
@RequiredArgsConstructor
public class musicService {
    String getMusic(String text){
        try {
            String apiKey = "cmcdaha5u0001l207duh4mmz3";  // 🔐 실제 API 키로 교체
            String jsonRequestBody = String.format("""
            {
              "prompt": "%s",
              "duration": 30
            }
            """, text);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.musicfy.lol/v1/generate-music"))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequestBody))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("음악 생성 실패, 상태 코드: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            if (!root.isArray() || root.size() == 0) {
                throw new RuntimeException("올바르지 않은 응답 구조: " + response.body());
            }

            String fileUrl = root.get(0).path("file_url").asText(null);
            if (fileUrl == null) {
                throw new RuntimeException("file_url을 찾을 수 없습니다: " + response.body());
            }

            return fileUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
