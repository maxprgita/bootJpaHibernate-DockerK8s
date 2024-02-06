package it.aips.aaBootJpaHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"it.aips.aaBootJpaHibernate"})
public class AaBootJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaBootJpaHibernateApplication.class, args);
	}
	
}
