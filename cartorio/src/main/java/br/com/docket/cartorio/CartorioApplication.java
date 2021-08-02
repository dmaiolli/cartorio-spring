package br.com.docket.cartorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"br.com.docket.cartorio.*"})
@EntityScan(basePackages = "br.com.docket.cartorio.model")
@ComponentScan(basePackages = {"br.com.docket.*"})
@EnableJpaRepositories(basePackages = {"br.com.docket.cartorio.repository"})
@EnableTransactionManagement
public class CartorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartorioApplication.class, args);
	}

}
