package com.github.mall.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName JwtTokenUtil
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/12 16:15
 * @ModifyDate 2019/9/12 16:15
 * @Version 1.0
 */
public class JwtTokenUtil {

    //过期时间
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    //私钥
    private static final String TOKEN_SECRET = "privateKey";

    /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法  私匙使用用户密码
     *
     * @return
     */
    public static String createJWT(String userName) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userName", userName);
        claims.put("date", new Date().toString());

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(EXPIRE_TIME))
                .signWith(signatureAlgorithm, TOKEN_SECRET);

        return builder.compact();
    }


    /**
     * 校验token
     * 在这里可以使用官方的校验，我这里校验的是token中携带的密码于数据库一致的话就校验通
     *
     * @param token
     * @return
     */
    public static Boolean isVerify(String token) {

        if (Objects.nonNull(token)) {
            //得到DefaultJwtParser
            Claims body = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();

            String userName = (String) body.get("userName");

            System.out.println("用户名====" + userName);

            if (userName.equals("admin")) {
                return true;
            }
        }
        return false;
    }
}
