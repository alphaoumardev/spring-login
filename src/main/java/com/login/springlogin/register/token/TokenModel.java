/*
  Created by:oumar
  Project:spring-login
  Name:Comfirmation
  Date: 8/14/2021
  Time: 2:31 PM
*/
package com.login.springlogin.register.token;

import com.login.springlogin.users.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TokenModel
{
    @Id
    @SequenceGenerator(name="Tokens",sequenceName="Tokens",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="Tokens")
    private Long id;

    @Column(nullable=false)
    private String token;

    @Column(nullable=false)
    private LocalDateTime createdAt;

    @Column(nullable=false)
    private LocalDateTime expiresAt;

    @ManyToOne
    @JoinColumn(nullable=false, name = "user_id")
    private UserModel userModel;

    private LocalDateTime confirmedAt;


    public TokenModel(String token, LocalDateTime createdAt, LocalDateTime expiresAt, UserModel userModel)
    {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.userModel = userModel;
    }
}



