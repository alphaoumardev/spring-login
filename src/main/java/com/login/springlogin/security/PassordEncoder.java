/*
  Created by:oumar
  Project:spring-login
  Name:PassordEncoder
  Date: 8/14/2021
  Time: 12:44 PM
*/
package com.login.springlogin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PassordEncoder
{
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
