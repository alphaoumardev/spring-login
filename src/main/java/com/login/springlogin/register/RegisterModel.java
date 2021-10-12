package com.login.springlogin.register;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RegisterModel
{
    @Id
    int Id;
    private String name;
    private String email;
    private String password;
}
