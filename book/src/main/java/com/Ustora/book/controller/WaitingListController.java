package com.Ustora.book.controller;

import com.Ustora.book.entities.WaitingList;
import com.Ustora.book.service.BookService;
import com.Ustora.book.service.ReservationService;
import com.Ustora.book.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
