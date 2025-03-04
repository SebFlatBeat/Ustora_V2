package com.Ustora.zuulserver.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ResponseFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        logger.info(" CODE HTTP {} ", response.getStatus());

        return null;
    }
}
