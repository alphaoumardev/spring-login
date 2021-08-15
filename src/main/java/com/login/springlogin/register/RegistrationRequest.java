/*
  Created by:oumar
  Project:spring-login
  Name:RegistrationRequest
  Date: 8/14/2021
  Time: 11:40 AM
*/
package com.login.springlogin.register;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest
{
    private String name;
    private String username;
    private String password;
    private String email;


}
