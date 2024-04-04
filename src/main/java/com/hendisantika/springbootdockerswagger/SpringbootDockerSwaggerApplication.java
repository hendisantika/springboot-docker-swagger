package com.hendisantika.springbootdockerswagger;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import com.hendisantika.springbootdockerswagger.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
@Slf4j
public class SpringbootDockerSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerSwaggerApplication.class, args);

    }

    @Bean
    public CommandLineRunner Initialize(CustomerRepository repository) {
        return args -> {
            // save a couple of customers
            repository.save(new Customer("Uzumaki", "Naruto"));
            repository.save(new Customer("Uchiha", "Sasuke"));
            repository.save(new Customer("Haruno", "Sakura"));
            repository.save(new Customer("Minato", "Namikaze"));
            repository.save(new Customer("Hendi", "Santika"));

            // fetch all customers
            Iterable<Customer> customers = repository.findAll();
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customers) {
                log.info(String.valueOf(customer));
            }
            log.info("================================");


            // fetch an individual customer by ID
            Customer customer = repository.findById(1L).get();
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(String.valueOf(customer));
            log.info("================================");

            // fetch customers by last name
            List<Customer> narutos = repository.findByLastName("Naruto");
            log.info("Customer found with findByLastName('Naruto'):");
            log.info("--------------------------------------------");
            for (Customer naruto : narutos) {
                log.info(String.valueOf(naruto));
            }
        };
    }
}
