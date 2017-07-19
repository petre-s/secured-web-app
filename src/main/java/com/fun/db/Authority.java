package com.fun.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by pstanaringa on 19.07.2017.
 */

@Embeddable
public class Authority implements GrantedAuthority {

    public Authority(){}

    public Authority(String authority) {
        this.authority = authority;
    }

    @Column(name = "role")
    private String authority;


    @Override
    public String getAuthority() {
        return authority;
    }
}
