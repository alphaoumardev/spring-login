package com.login.springlogin.register;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class RegisterModel
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
