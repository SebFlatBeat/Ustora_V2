package com.Ustora.user.dao;

import com.Ustora.user.entities.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserBook, Long> {
   UserBook findByUsername(String username);

   List<UserBook> findAll();

   UserBook save(UserBook userBook);
}
