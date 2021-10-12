package com.login.springlogin.users;

import com.login.springlogin.register.token.TokenModel;
import com.login.springlogin.register.token.TokenService;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;
    private final static String USERNAME_NOT_FOUND_EXCEPTION="The user with this %s is not found";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return userRepo.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USERNAME_NOT_FOUND_EXCEPTION,email)));
    }

    public String signUp(UserModel userModel)
    {
        boolean userExists= userRepo.findByEmail(userModel.getEmail()).isPresent();//we have to add the present
        if(userExists)
        {
//            TODO check the attributes are the same and
//            TODO if the email is not confirmed, resend it again

            throw new IllegalStateException("The email is been taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);//to set the new password

        userRepo.save(userModel);//and then save the user
        String token = UUID.randomUUID().toString();

        TokenModel bean = new TokenModel(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                userModel);

        tokenService.saveToken(bean);
//        TODO send  email
        return token;
    }

    public void enableUser(String email)
    {
        userRepo.enableUser(email);
    }
}
