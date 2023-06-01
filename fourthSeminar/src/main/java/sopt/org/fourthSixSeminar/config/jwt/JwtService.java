
package sopt.org.fourthSixSeminar.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sopt.org.fourthSixSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.fourthSixSeminar.domain.User;
import sopt.org.fourthSixSeminar.exception.Error;
import sopt.org.fourthSixSeminar.exception.model.UnauthorizedException;
import sopt.org.fourthSixSeminar.infrastructure.UserRepository;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import static sopt.org.fourthSixSeminar.exception.Error.TOKEN_TIME_EXPIRED_EXCEPTION;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    //RefreshToken 발급

    public String generateRefreshToken(UserLoginRequestDto request){
        User user=userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(()->new UnauthorizedException(TOKEN_TIME_EXPIRED_EXCEPTION, TOKEN_TIME_EXPIRED_EXCEPTION.getMessage()));
        Long userId=user.getId();

        RefreshToken refreshToken=new RefreshToken(UUID.randomUUID().toString(),userId);
        refreshTokenRepository.save(refreshToken);

        return refreshToken.getRefreshToken();
    }
    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder()
                .encodeToString(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    // JWT 토큰 발급
    public String issuedToken(String userId) {
        final Date now = new Date();

        // 클레임 생성
        final Claims claims = Jwts.claims()
                .setSubject("access_token")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 1000L));

        //private claim 등록
        claims.put("userId", userId);

        return Jwts.builder()
                .setHeaderParam(Header.TYPE , Header.JWT_TYPE)
                .setClaims(claims)
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {
        final byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 토큰 검증
    public boolean verifyToken(String token) {
        try {
            final Claims claims = getBody(token);
            return true;
        } catch (RuntimeException e) {
            if (e instanceof ExpiredJwtException) {
                throw new UnauthorizedException(TOKEN_TIME_EXPIRED_EXCEPTION, TOKEN_TIME_EXPIRED_EXCEPTION.getMessage());
            }
            return false;
        }
    }

    private Claims getBody(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // JWT 토큰 내용 확인
    public String getJwtContents(String token) {
        final Claims claims = getBody(token);
        return (String) claims.get("userId");
    }


}
