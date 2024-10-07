package ma.trellobackend.trellobackend.dtos.res;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
}
