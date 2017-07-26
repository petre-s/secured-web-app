package com.fun.db;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by pstanaringa on 19.07.2017.
 */
@Entity
@Table(name = "users")
public class User implements UserDetails{
    public User(){}

    public User(String username, String password, String email, Boolean enabled, List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="user_roles",
            joinColumns=@JoinColumn(name="user_id")
    )
    private List<Authority> authorities;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Tag> tagList;

    @Transient
    private Boolean accountNonExpired = true;

    @Transient
    private Boolean accountNonLocked = true;

    @Transient
    private Boolean credentialsNonExpired = true;


    @Override
    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
