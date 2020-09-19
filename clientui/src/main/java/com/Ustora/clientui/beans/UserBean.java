package com.Ustora.clientui.beans;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserBean  implements UserDetails{

    private Long id;

    private String username;

    private String email;

    private String password;

    private List<UserRole> userRoleList;

    public UserBean() {

    }

    public UserBean(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.userRoleList.forEach(userRole -> authorities.add(new SimpleGrantedAuthority(userRole.toString())));
        return authorities;
    }

    public void grantAuthority(UserRole authority) {
        if ( userRoleList == null ) userRoleList = new ArrayList<>();
        userRoleList.add(authority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<UserRole> authorities) {
        this.userRoleList = authorities;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @Override
    public String toString() {
        return "UserBean [username=" + username + ", email=" + email
                + ", password=" + password + "]";
    }
}
