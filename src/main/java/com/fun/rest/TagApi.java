package com.fun.rest;

import com.fun.db.Tag;
import com.fun.db.TagRepository;
import com.fun.db.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Created by pstanaringa on 27.07.2017.
 */
@RestController
@RequestMapping(path = TagApi.url)
public class TagApi {
    public static final String url = "/api/v1/users/{userId}/tags";
    private TagRepository tagRepository;

    @Autowired
    public TagApi(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public ResponseEntity createTag(@RequestBody Tag newTag,
                         @AuthenticationPrincipal User user){
        newTag.setUser(user);
        Tag savedTag =  tagRepository.save(newTag);
        return  ResponseEntity.created(URI.create(url+"/"+savedTag.getId())).body(savedTag);
    }

}
