package com.hendisantika.springbootdockerswagger.controller;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import com.hendisantika.springbootdockerswagger.service.CustomerService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/02/18
 * Time: 19.55
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/apis/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "Create Customer", response = Customer.class, httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @ApiOperation(value = "List Customers", response = Customer.class, responseContainer = "List", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}