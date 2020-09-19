package com.Ustora.clientui.service;

import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.beans.UserRole;
import com.Ustora.clientui.proxies.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserBookService implements UserDetailsService {
    @Autowired
    UserProxy userProxy;

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBook = userProxy.login(username);
        if (userBook != null){
            return new  User(userBook.getUsername(),userBook.getPassword(),userBook.getAuthorities());
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
