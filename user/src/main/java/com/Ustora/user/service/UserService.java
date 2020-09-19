package com.Ustora.user.service;

import com.Ustora.user.dao.UserDao;
import com.Ustora.user.entities.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public UserBook findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public List<UserBook> findAll() {return userDao.findAll();}

    public   UserBook save(UserBook userBook) {return userDao.save(userBook);}

    public Optional<UserBook> findById(Long id) {
        return userDao.findById(id);
    }
}
