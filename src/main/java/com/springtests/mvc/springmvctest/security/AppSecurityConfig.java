package com.springtests.mvc.springmvctest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    //returns the authentication provider- ours will be db
    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        //no encoding
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        //spring has default encoder for bcrypt
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

    /* Manual in memory usage
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        List<UserDetails> users=new ArrayList<>();
        users.add(User.withDefaultPasswordEncoder().username("test1").password("123").roles("USER").build());
        users.add(User.withDefaultPasswordEncoder().username("test2").password("123").roles("ADMIN").build());
        return new InMemoryUserDetailsManager(users);
    }
    */
}
