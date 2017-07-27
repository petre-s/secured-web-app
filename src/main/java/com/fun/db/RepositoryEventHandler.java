package com.fun.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by petre on 26.07.2017.
 */
@org.springframework.data.rest.core.annotation.RepositoryEventHandler
@Component
public class RepositoryEventHandler {

    @HandleBeforeCreate
    public void beforeSave(Tag tag){
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (o instanceof User)
            tag.setUser((User) o);
    }
}
