/*
  Created by:oumar
  Project:spring-login
  Name:RegisterController
  Date: 8/14/2021
  Time: 11:33 AM
*/
package com.login.springlogin.register;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/register")
@AllArgsConstructor
public class RegisterController
{
    private final RegistrationService registrationService;

    @PostMapping
    public String registeration(@RequestBody RegistrationRequest request)
    {
        return registrationService.register(request);
    }
    @GetMapping(path="/confirm")
    public String confirm(@RequestParam("token")String token )
    {
        return registrationService.confirmToken(token);
    }
}
