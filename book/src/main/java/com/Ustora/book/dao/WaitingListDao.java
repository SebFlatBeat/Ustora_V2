package com.Ustora.book.dao;

import com.Ustora.book.entities.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface WaitingListDao extends JpaRepository<WaitingList, Long> {

    List<WaitingList> findAll();

    Optional<WaitingList> findById(Long id);

    List<WaitingList> findByUserBookId(Long userBookId);

    WaitingList save(WaitingList waitingList);

    void delete(WaitingList waitingList);

}
