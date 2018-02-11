package com.hendisantika.springbootdockerswagger.service;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import com.hendisantika.springbootdockerswagger.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/02/18
 * Time: 07.07
 * To change this template use File | Settings | File Templates.
 */
@Component("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository = null;

    /* (non-Javadoc)
     * @see com.synerzip.template.springboot.services.CustomerService#getAllCustomers()
     */
    @Override
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
