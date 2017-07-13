package com.fun.securedwebapp;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;
import java.nio.file.attribute.UserPrincipal;

/**
 * Created by pstanaringa on 06.07.2017.
 */
@RestController
@RequestMapping("/webapi/v1")
public class SampleRest {

    @Autowired
    private SessionResource sessionResource;

    @Autowired
    private HttpSession httpSession;
    private String myName;

    @RequestMapping(method = RequestMethod.GET)
    public String getSample(@AuthenticationPrincipal User userPrincipal){
       // httpSession.setMaxInactiveInterval(5);
        return httpSession.getId() + " " + sessionResource.getCount() ;
    }

    @RequestMapping(value="/secured", method = RequestMethod.GET)
    public String getSample2(@AuthenticationPrincipal User userPrincipal){
        return userPrincipal.getUsername()+" " +userPrincipal.getPassword();
    }
}
