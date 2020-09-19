package com.Ustora.zuulserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {

	private static Logger logger = LoggerFactory.getLogger(ZuulServerApplication.class);

	public static void main(String[] args) {

		logger.info("Démarrage de l'application Zuul-Server");

		SpringApplication.run(ZuulServerApplication.class, args);
	}

}
