package com.mftplus.secondsecurityservice.service;

import com.mftplus.secondsecurityservice.dto.UserUserDetails;
import com.mftplus.secondsecurityservice.entity.User;
import com.mftplus.secondsecurityservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class UserUserDetailsService implements UserDetailsService {

    @Autowired //TODO: Constructor Injection
     UserRepository repository;
//    private final UserRepository repository;

//    public UserUserDetailsService(UserRepository repository) {
//        this.repository = repository;
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findUserByUsernameAndDeletedFalse(username);
        return userInfo.map(UserUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
