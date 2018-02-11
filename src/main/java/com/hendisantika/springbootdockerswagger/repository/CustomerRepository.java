package com.hendisantika.springbootdockerswagger.repository;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/02/18
 * Time: 07.05
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}