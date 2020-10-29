package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The interface Reservation dao.
 */
public interface ReservationDao extends JpaRepository<Reservation, Long> {

    /**
     * Find reservations by user book id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Reservation> findReservationsByUserBookId (Long userId);

    /**
     *
     * @param id
     * @return
     */
    Optional<Reservation> findById(Long id);

    /**
     *
     * @param reservation
     * @return
     */
    Reservation save(Reservation reservation);

    /**
     *
     * @param reservation
     */
    void delete(Reservation reservation);

    /**
     * Find by end borrowing after list.
     *
     * @param endBorrowing the end borrowing
     * @return the list
     */
    @Query("select reservation from Reservation reservation where reservation.endBorrowing>=:endBorrowing")
    List<Reservation> findByEndBorrowingAfter(@Param("endBorrowing")Date endBorrowing);

    /**
     *
     * @param bookId
     * @return
     */
    List<Reservation> findAllByBookIdOrderByEndBorrowingAsc(Long bookId);
}
