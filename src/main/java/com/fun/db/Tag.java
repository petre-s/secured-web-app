package com.fun.db;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pstanaringa on 13.07.2017.
 */
@Entity
@Table(name = "TAG")
public class Tag implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemTag> itemTagList;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemTag> getItemTagList() {
        return itemTagList;
    }

    public void setItemTagList(List<ItemTag> itemTagList) {
        this.itemTagList = itemTagList;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
