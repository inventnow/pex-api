package com.inventnow.projectx.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypt {

    @Test
    public void testPassword(){
        String password ="password";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.print(bCryptPasswordEncoder.encode(password));
    }
}
