package com.Ustora.book.proxies;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * The interface User proxy.
 */
@FeignClient(name = "zuul-server", contextId="userProxy", configuration= FeignConfig.class, url = "http://localhost:9004" )
@RibbonClient(name = "user")
@Component
public interface UserProxy {

    /**
     * Find user bean.
     *
     * @param username the username
     * @return user bean
     */
    @GetMapping(value = "/user/find/{username}")
    UserBean find(@PathVariable String username);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return optional
     */
    @GetMapping(value = "/user/find/id")
    Optional<UserBean> findById(@RequestParam Long id);
}
