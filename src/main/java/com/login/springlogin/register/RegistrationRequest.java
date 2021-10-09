package com.login.springlogin.register;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RegistrationRequest
{
    @Id
    int Id;
    private String name;
    private String username;
    private String password;
    private String email;
}
