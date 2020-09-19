package com.Ustora.book;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * The type Book application.
 */
@SpringBootApplication
@EnableFeignClients("com.Ustora.book")
@EnableDiscoveryClient
@EnableScheduling
public class BookApplication {

	private static Logger logger = LoggerFactory.getLogger(BookApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


		logger.info("Démarrage de l'application Book");

		SpringApplication.run(BookApplication.class, args);


	}

}
