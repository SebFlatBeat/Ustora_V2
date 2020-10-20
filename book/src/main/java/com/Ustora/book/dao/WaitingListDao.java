package com.Ustora.book.dao;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface WaitingListDao extends JpaRepository<WaitingList, Long> {

    //Trouver toutes les reservations
    List<WaitingList> findAll();

    //Trouver une reservation par son Id
    Optional<WaitingList> findById(Long id);

    //Enregistrer une reservation
    WaitingList save(WaitingList waitingList);

    //Supprimer une reservation
    void deleteById(Long id);

    //Trouver les reservations pour un user et ranger par date de la demande
    List<WaitingList> findByUserBookIdAndStatusOrderByDateOfDemandAsc(Long userBookId, Status status);

    //Trouver toutes les reservations pour un user et ranger par date de la demande
    List<WaitingList> findAllByUserBookIdAndStatusOrderByDateOfDemandAsc(Long userBookId, Status status);

    //Trouver toutes les reservations d'un livre
    List<WaitingList> findAllByBookAndStatusOrderByDateOfDemandAsc(Book book, Status status);

    //Trouver une reservation pour un livre
    List<WaitingList> findByBookAndStatusOrderByDateOfDemandAsc(Book book, Status status);

    //Trouver les reservations par status et mail de reservation envoyé ou non
    List<WaitingList> findByMailSendAndStatus(Boolean mailSend, Status status);

    //Trouver les reservations par l'id du user
    List<WaitingList> findByUserBookId(Long userBookId);

}
