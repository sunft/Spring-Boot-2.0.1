package com.sunft.blog.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by sunft on 2018/5/14.
 *
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
