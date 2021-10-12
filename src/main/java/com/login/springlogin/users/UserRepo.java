/*
  Created by:oumar
  Project:spring-login
  Name:UserRepo
  Date: 8/14/2021
  Time: 11:14 AM
*/
package com.login.springlogin.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<UserModel,Long>
{
    @Transactional
    @Modifying
//    @Query("UPDATE UserModel a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    void enableUser(String email);

    Optional<UserModel> findByEmail(String email);
}
