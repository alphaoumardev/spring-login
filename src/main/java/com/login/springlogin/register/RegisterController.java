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
@AllArgsConstructor
@RequestMapping("api/v1/registration")
public class RegisterController
{
    private final RegisterService registerService;

    @PostMapping()
    public String registeration(@RequestBody RegisterModel request)
    {
        return registerService.register(request);
    }
    @GetMapping("confirm")
    public String confirm(@RequestParam("token")String token )
    {
        return registerService.confirmToken(token);
    }
}
