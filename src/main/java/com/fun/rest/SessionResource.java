package com.fun.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Created by pstanaringa on 11.07.2017.
 */
@Component
@SessionScope
public class SessionResource {
    private static int count;
    private int myCount;

    public SessionResource(){
        myCount = count++;
    }


    public int getCount() {
        return myCount;
    }
}
