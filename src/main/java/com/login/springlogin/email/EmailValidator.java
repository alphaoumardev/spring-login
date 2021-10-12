/*
  Created by:oumar
  Project:spring-login
  Name:EmailValidator
  Date: 8/14/2021
  Time: 1:44 PM
*/
package com.login.springlogin.email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String>
{
    @Override
    public boolean test(String s) {
        return true;
    }
}
