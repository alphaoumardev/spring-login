/*
  Created by:oumar
  Project:spring-login
  Name:ComfirmationRepo
  Date: 8/14/2021
  Time: 2:57 PM
*/
package com.login.springlogin.register.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComfirmationRepo extends JpaRepository<Comfirmation, Long>
{
    Optional<Comfirmation> findByToken(String token);

}
