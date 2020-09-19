package com.Ustora.clientui.proxies;

import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "zuul-server", contextId="userProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "user")
@Component
public interface UserProxy {

    /**
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/user/{username}/login")
    UserBean login(@PathVariable String username);

    /**
     *
     * @param userBean
     * @return
     */
    @PostMapping(value = "/user/registerPost")
    UserBean register(UserBean userBean);

    /**
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/user/find/{username}")
    UserBean find(@PathVariable String username);

}