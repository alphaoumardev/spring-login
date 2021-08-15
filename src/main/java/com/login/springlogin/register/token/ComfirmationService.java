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

@Service
@AllArgsConstructor
public class ComfirmationService
{
    private final ComfirmationRepo comfirmationRepo;

    public void saveComfirmation(Comfirmation token)
    {
        comfirmationRepo.save(token);
    }

}
