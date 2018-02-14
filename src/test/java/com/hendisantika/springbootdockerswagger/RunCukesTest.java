package com.hendisantika.springbootdockerswagger;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/02/18
 * Time: 21.46
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
        "html:target/test-report",
        "json:target/test-report.json",
        "junit:target/test-report.xml"})
public class RunCukesTest {
}
