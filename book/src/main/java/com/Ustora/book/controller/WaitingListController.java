package com.Ustora.book.controller;

import com.Ustora.book.beans.WaitingListBean;
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

    @GetMapping("/allUserWaitingList/{id}")
    public List<WaitingListBean> afficherLesReservations(@PathVariable("id") Long id , @RequestParam Long userBookId){
    return waitingListService.afficherLesReservation(id);
    }

    @GetMapping("/pendingWaitingList")
    public List<WaitingList> pendingAndMailSent(){
        return waitingListService.pendingAndMailSent();
    }

    @PostMapping("/waitingListAdd/{id}")
    public void demandeDeReservation(@PathVariable("id") Long id, @RequestParam Long userBookId){
        waitingListService.waitingListReservation(id,userBookId);
    }

    @PostMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable("id") Long id,@RequestParam Long userBookId){
        waitingListService.cancel(id,userBookId);
    }
}
