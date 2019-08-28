package com.ProjetoSenai.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.loja.SenaiLoja.model")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.loja.SenaiLoja.repository"})
@EnableTransactionManagement
public class ProjetoSenaiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSenaiApplication.class, args);
	}

}
