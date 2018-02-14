package com.hendisantika.springbootdockerswagger;

import com.hendisantika.springbootdockerswagger.domain.Customer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/02/18
 * Time: 21.43
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicStepdefs {
    final String BASE_URL = "http://localhost:8080/apis/customers";

    private RestTemplate rest = new RestTemplate();

    @Before
    public void setup() {

    }

    @After
    public void destroy() {

    }

    @When("^I store a new Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\"$")
    public void storeCustomer(String firstName, String lastName) {
        System.out.println("When I store a Customer[firstName=\"" + firstName + "\",lastName=\"" + lastName + "\"]");

        Customer customer = new Customer(firstName, lastName);
        ResponseEntity<Customer> response = rest.postForEntity(BASE_URL, customer, Customer.class);
        Customer returnedCustomer = response.getBody();
        assertEquals(customer.getFirstName(), returnedCustomer.getFirstName());
        assertEquals(customer.getLastName(), returnedCustomer.getLastName());


    }


    @Then("^I expect to see Customer\\[firstname=\"(.*?)\",lastname=\"(.*?)\" in List of Customers$")
    public void i_expect_to_see(String firstName, String lastName) {
        System.out.println("I expect to see Customer[firstname=\"" + firstName + "\",lastname=\"" + lastName + "\" in List of Customers");

        ResponseEntity<Customer[]> response = rest.getForEntity(BASE_URL,
                Customer[].class);

        Customer customer = new Customer(firstName, lastName);
        Customer[] customers = response.getBody();

        boolean matchfound = false;
        for (Customer entity : customers) {
            if (entity.getFirstName().equals(customer.getFirstName()) && entity.getLastName().equals(customer.getLastName())) {
                matchfound = true;
            }
        }

        assertTrue("Did not find Customer in return list", matchfound);
    }
}