package br.pucrs.bruno.laitano.subscriptionmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"br.pucrs.bruno.laitano.subscriptionmanagement"})
public class SubscriptionmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionmanagementApplication.class, args);
	}
}