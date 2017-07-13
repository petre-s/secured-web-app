package com.fun.securedwebapp;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by pstanaringa on 06.07.2017.
 */
public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(WebSecurityConfig.class);
    }
}