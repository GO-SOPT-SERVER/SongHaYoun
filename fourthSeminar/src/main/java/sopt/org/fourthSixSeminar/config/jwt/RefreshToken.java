package sopt.org.fourthSixSeminar.config.jwt;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@RedisHash(value="refreshToken", timeToLive = 60)
public class RefreshToken {

    @Id
    private String refreshToken;
    private Long userId;

    @Builder
    private RefreshToken(final String refreshToken,final Long userId){
        this.refreshToken=refreshToken;
        this.userId=userId;
    }

}
