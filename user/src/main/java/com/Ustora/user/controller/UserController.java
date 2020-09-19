package com.Ustora.user.controller;

import com.Ustora.user.entities.UserBook;
import com.Ustora.user.entities.UserRole;
import com.Ustora.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @return
     */
    @GetMapping("/all-account")
    public List<UserBook> userBookList (){
        List<UserBook> userBooks = userService.findAll();
        logger.info("Renvoi de tous les comptes");
        return userBooks;
    }

    /**
     *
     * @param username
     * @return
     */
    @GetMapping("/{username}/login")
    public UserBook login (@PathVariable String username){
        UserBook userBook = userService.findByUsername(username);
        logger.info("Renvoi de l'utilisateur");
        return userBook;
    }

    /**
     *
     * @param userBook
     * @return
     */
    @PostMapping(value = "/registerPost")
    public UserBook register(@RequestBody UserBook userBook) {
        userService.save(userBook);
        logger.info("Renvoi de l'utilisateur enregistré");
        return userBook;
    }

    /**
     *
     * @param username
     * @return
     */
    @GetMapping("/find/{username}")
    public UserBook findCurrentUser(@PathVariable String username){
        UserBook userBook =userService.findByUsername(username);
        logger.info("Retour de la recherche par username");
        return userBook;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/find/id")
    public Optional<UserBook> findById (@RequestParam Long id) {
        Optional<UserBook> userBook = userService.findById(id);
        logger.info("Renvoi de la recherche par Id");
        return userBook;
    }
}
