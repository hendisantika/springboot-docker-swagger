package com.hendisantika.springbootdockerswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-docker-swagger
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/02/18
 * Time: 19.54
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SwaggerConfig {

//    private SpringSwaggerConfig springSwaggerConfig;
//
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
//
//    @Bean //Don't forget the @Bean annotation
//    public SwaggerSpringMvcPlugin customImplementation() {
//        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
//                .apiInfo(apiInfo()).apiVersion("1.0").includePatterns(".*apis.*");
//    }
//
//
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Restful API Documentation",
//                "Template of SpringBoot, JPA, Gradle and Swagger",
//                "API terms of service",
//                "hendisantika@gmail.com",
//                "API Licence Type",
//                "API License URL"
//        );
//        return apiInfo;
//    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Restful API Documentation")
                .description("Restful API Documentation")
                .version("v0.0.1")
                .contact(getContactDetails()));
    }

    private Contact getContactDetails() {
        return new Contact().name("Hendi Santika")
                .email("hendisantika@yahoo.co.id")
                .url("https://s.id/hendisantika");
    }
}
