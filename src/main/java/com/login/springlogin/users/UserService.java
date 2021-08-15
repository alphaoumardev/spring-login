package com.login.springlogin.users;

import com.login.springlogin.register.token.Comfirmation;
import com.login.springlogin.register.token.ComfirmationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService
{
    private final UserRepo userRepo;
    private final static String USERNAME_NOT_FOUND_EXCEPTION="The user with this %s is not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ComfirmationService comfirmationService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return userRepo.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_EXCEPTION,email)));
    }
    public String signUp(User user)
    {
        boolean userExists= userRepo.findByEmail(user.getEmail()).isPresent();//we have to add the present
        if(userExists)
        {
            throw new IllegalStateException("The email is been taken");
        }

        String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);//to set the new password

        userRepo.save(user);//and then save the user
//        TODO send comfirmation taken forward
        String uuid = UUID.randomUUID().toString();
        Comfirmation comfirmationToken = new Comfirmation(uuid,LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);

        comfirmationToken.saveComfirmation(comfirmationToken);
//        TODO send  email
        return uuid;
    }
}
