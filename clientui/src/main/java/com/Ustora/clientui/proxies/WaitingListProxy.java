package com.Ustora.clientui.proxies;


import com.Ustora.clientui.beans.WaitingListBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "zuul-server", contextId="waitingListProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
public interface WaitingListProxy {

    @GetMapping(value = "/waitingList/allWaitingList")
    List<WaitingListBean> waitingList();

    @GetMapping(value = "/waitingList/userWaitingList")
    List<WaitingListBean> waitingList(@RequestParam Long userId);

    @GetMapping(value = "/waitingList/allUserWaitingList/{id}")
    List<WaitingListBean> afficherLesReservations(@PathVariable("id") Long id);

    @PostMapping(value = "/waitingList/waitingListAdd/{id}")
    void demandeDeReservation(@PathVariable("id") Long id, @RequestParam Long userBookId);

    @PostMapping(value = "/waitingList/cancel/{id}")
    void cancelReservation(@PathVariable("id") Long id, @RequestParam Long userBookId);
}
