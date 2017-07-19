package com.fun.securedwebapp;

import com.fun.db.TagRepository;
import com.fun.db.User;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

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

    private final TagRepository tagRepository;

    @Autowired
    public SampleRest(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getSample(@AuthenticationPrincipal User userPrincipal){

        return tagRepository.findAll().toString();

        //return "test";
    }

    @RequestMapping(value="/secured", method = RequestMethod.GET)
    public String getSample2(@AuthenticationPrincipal User userPrincipal){
        return userPrincipal.getUsername()+" " +userPrincipal.getPassword();
    }
}
