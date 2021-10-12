/*
  Created by:oumar
  Project:spring-login
  Name:User
  Date: 8/14/2021
  Time: 10:45 AM
*/
package com.login.springlogin.users;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserModel implements UserDetails// we implements the userDetails
{
    @Id
    @SequenceGenerator(name="Student",sequenceName="Student",allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="Student")
    private Long id;
    private String password;
    private String name;
    private String email;
    private boolean locked=false;
    private boolean enabled=false;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    public UserModel(String name, String password, String email, UserRole userRole)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;

    }

    public UserModel(String name, String username, String password, String email, UserRole user) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}