package com.Ustora.book.controller;

import com.Ustora.book.beans.WaitingListBean;
import com.Ustora.book.entities.Status;
import com.Ustora.book.entities.WaitingList;
import com.Ustora.book.service.BookService;
import com.Ustora.book.service.ReservationService;
import com.Ustora.book.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WaitingListController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private WaitingListService waitingListService;

    @GetMapping("/allWaitingList")
    public List<WaitingList> listWaitingListAll (){
        return waitingListService.findAll();
    }

    @GetMapping("/userWaitingList")
    public List<WaitingList> userBookWaitingList(@RequestParam Long userBookId){
        return waitingListService.findByUserBookId(userBookId);
    }

    @GetMapping("/allUserWaitingList")
    public List<WaitingListBean> afficherLesReservations( @RequestParam Long userBookId){
    return waitingListService.afficherLesReservation(userBookId);
    }

    @GetMapping("/pendingWaitingList")
    public List<WaitingList> pendingAndMailSent(){
        return waitingListService.pendingAndMailSent();
    }

    @PostMapping("/waitingListAdd")
    public void demandeDeReservation(@RequestParam Long bookId, @RequestParam Long userBookId){
        waitingListService.waitingListReservation(bookId,userBookId);
    }

    @PostMapping("/cancel")
    public void cancelReservation(@RequestParam Long id,@RequestParam Long userBookId){
        waitingListService.cancel(id,userBookId);
    }

    @GetMapping("/waitingList/book")
    public List<WaitingListBean> waitingListByBookId(@RequestParam Long bookId){
        return  waitingListService.findByBookId(bookId);
    }

}
