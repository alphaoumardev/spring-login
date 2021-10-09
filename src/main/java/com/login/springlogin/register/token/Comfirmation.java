/*
  Created by:oumar
  Project:spring-login
  Name:Comfirmation
  Date: 8/14/2021
  Time: 2:31 PM
*/
package com.login.springlogin.register.token;

import com.login.springlogin.users.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Comfirmation
{
    @Id
    @SequenceGenerator(name="Comfirmation",sequenceName="Comfirmation",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="Comfirmation")
    private Long id;
    @Column(nullable=false)
    private String token;
    @Column(nullable=false)
    private LocalDateTime createdAt;
    @Column(nullable=false)
    private LocalDateTime expiresAt;
    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

    public Comfirmation(String token, LocalDateTime createdAt, LocalDateTime expiresAt,User user)
    {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user=user;
    }




}
