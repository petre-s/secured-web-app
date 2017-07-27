package com.fun;

import com.fun.services.DatabaseUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * Created by pstanaringa on 06.07.2017.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private DatabaseUserDetailService databaseUserDetailService;

    @Autowired
    public void setDatabaseUserDetailService(DatabaseUserDetailService databaseUserDetailService) {
        this.databaseUserDetailService = databaseUserDetailService;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/api/v1/secured/**").authenticated()
                    //.antMatchers("/api/v1/users/{userId}/**").access("isAuthenticated() and @secValue.test(#userId)")
                    .antMatchers("/api/v1/users/{userId}/**")
                            .access("isAuthenticated() and #userId.toString().equals(principal.id.toString())")
                .and().formLogin()
                .and().httpBasic()
                .and().rememberMe().key("dasdsa")
                .and().requiresChannel().anyRequest().requiresSecure()
                .and().csrf().disable();

    }


    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(databaseUserDetailService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
