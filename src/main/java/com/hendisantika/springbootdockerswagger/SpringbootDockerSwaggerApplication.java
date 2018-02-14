package com.hendisantika.springbootdockerswagger;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import com.hendisantika.springbootdockerswagger.repository.CustomerRepository;
import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableSwagger
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
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            System.out.println();


            // fetch an individual customer by ID
            Customer customer = repository.findOne(1L);
            System.out.println("Customer found with findOne(1L):");
            System.out.println("--------------------------------");
            System.out.println(customer);
            System.out.println();

            // fetch customers by last name
            List<Customer> narutos = repository.findByLastName("Naruto");
            System.out.println("Customer found with findByLastName('Naruto'):");
            System.out.println("--------------------------------------------");
            for (Customer naruto : narutos) {
                System.out.println(naruto);
            }
        };
    }
}
