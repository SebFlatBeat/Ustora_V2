package com.Ustora.clientui.proxies;


import com.Ustora.clientui.beans.WaitingListBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "zuul-server", contextId="waitingListProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "book")
@Component
public interface WaitingListProxy {

    @GetMapping(value = "/book/allWaitingList")
    List<WaitingListBean> waitingList();

    @GetMapping(value = "/book/userWaitingList")
    List<WaitingListBean> waitingList(@RequestParam Long userBookId);

    @GetMapping(value = "/book/allUserWaitingList")
    List<WaitingListBean> afficherLesReservations(@RequestParam Long userBookId);

    @PostMapping(value = "/book/waitingListAdd")
    void demandeDeReservation(@RequestParam Long bookId, @RequestParam Long userBookId);

    @PostMapping(value = "/book/cancel")
    void cancelReservation(@RequestParam Long id, @RequestParam Long userBookId);
}
