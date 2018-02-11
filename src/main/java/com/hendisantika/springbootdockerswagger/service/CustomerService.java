package com.hendisantika.springbootdockerswagger.service;

import com.hendisantika.springbootdockerswagger.domain.Customer;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/02/18
 * Time: 07.06
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {
    Iterable<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);
}
