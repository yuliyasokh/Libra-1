package com.netcracker.libra.util.security;

import org.springframework.util.DigestUtils;

/**
 *
 * @author MorrDeck
 */
public class Security {

    public static String getMD5hash(String source){
        return DigestUtils.md5DigestAsHex(source.getBytes());
    }
}
