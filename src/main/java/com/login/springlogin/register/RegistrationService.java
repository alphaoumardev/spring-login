/*
  Created by:oumar
  Project:spring-login
  Name:RegistrationService
  Date: 8/14/2021
  Time: 11:41 AM
*/
package com.login.springlogin.register;

import com.login.springlogin.register.token.Comfirmation;
import com.login.springlogin.register.token.ComfirmationService;
import com.login.springlogin.users.User;
import com.login.springlogin.users.UserRole;
import com.login.springlogin.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistrationService
{
    private final EmailValidator emailValidator;
    private final UserService userService;
    private final ComfirmationService comfirmationService;

    //    private final EmailSender emailSender;

    public String register(RegistrationRequest request)
    {
        boolean isValidEmail=emailValidator.test(request.getEmail());
        if(!isValidEmail)
        {
            throw new IllegalStateException("The email is not valid try again");
        }
        //        emailSender.send(request.getEmail(),"oumardialo98@qq.com");
        return userService.signUp(new User(request.getName(),request.getUsername(),request.getPassword(),request.getEmail(), UserRole.USER));
    }

    @Transactional
    public String confirmToken(String token)
    {
        Comfirmation comfirmation= comfirmationService.getToken(token).orElseThrow(()-> new IllegalStateException("The token is not found"));
        if(comfirmation.getConfirmedAt()!=null)
        {
            throw new IllegalStateException("The email is been confirmed");
        }
        return "Confirmed";
    }
}
