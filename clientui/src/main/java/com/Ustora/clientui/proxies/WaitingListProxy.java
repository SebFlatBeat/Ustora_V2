package com.Ustora.clientui.proxies;


import com.Ustora.clientui.beans.WaitingListBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "zuul-server", contextId="waitingListProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
public interface WaitingListProxy {

    @GetMapping(value = "/waitingList/userWaitingList")
    List<WaitingListBean> waitingList(@RequestParam Long userId);
}
