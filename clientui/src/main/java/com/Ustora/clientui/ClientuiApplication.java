package com.Ustora.clientui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableFeignClients("com.Ustora.clientui")
@EnableDiscoveryClient
public class ClientuiApplication {

	private static Logger logger = LoggerFactory.getLogger(ClientuiApplication.class);

	public static void main(String[] args) {
		logger.info("Démarrage de l'application ClientUI");
		SpringApplication.run(ClientuiApplication.class, args);
	}

}
