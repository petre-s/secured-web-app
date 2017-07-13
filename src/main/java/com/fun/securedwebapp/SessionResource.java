package com.fun.securedwebapp;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by pstanaringa on 11.07.2017.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionResource {
    private static int count;
    private int myCount;

    public SessionResource(){
        myCount = count++;
    }


    public int getCount() {
        return myCount;
    }

    @PreDestroy
    public void preDestroy(){
        myCount = 0;
    }
}
