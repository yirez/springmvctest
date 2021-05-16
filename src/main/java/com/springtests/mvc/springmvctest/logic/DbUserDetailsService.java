package com.springtests.mvc.springmvctest.logic;

import com.springtests.mvc.springmvctest.model.User;
import com.springtests.mvc.springmvctest.repository.UserRepository;
import com.springtests.mvc.springmvctest.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("User not in db");

        return new UserPrincipal(user);
    }
}
