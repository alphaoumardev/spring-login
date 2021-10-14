package com.login.springlogin.register.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface TokenRepo extends JpaRepository<TokenModel, Long>
{
    Optional<TokenModel> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE TokenModel c SET c.confirmedAt = ?2 WHERE  c.token = ?1")
    int updateConfirmedAt(String token,  LocalDateTime confirmedAt);
}
