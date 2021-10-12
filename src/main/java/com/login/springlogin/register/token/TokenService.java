/*
  Created by:oumar
  Project:spring-login
  Name:ComfirmationService
  Date: 8/14/2021
  Time: 2:56 PM
*/
package com.login.springlogin.register.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService
{
    private final TokenRepo tokenRepo;

    public void saveToken(TokenModel token)
    {
        tokenRepo.save(token);
    }
    public Optional<TokenModel> getToken(String token)
    {
        return tokenRepo.findByToken(token);
    }
    public int setConfirmedAt(String token)
    {
        return tokenRepo.updateConfirmedAt(token, LocalDateTime.now());
    }

}
